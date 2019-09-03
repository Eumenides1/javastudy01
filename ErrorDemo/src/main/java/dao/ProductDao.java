package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import common.DBUtils;
import vo.ProductInfo;
import vo.ProductInfo;

public class ProductDao {

	// ����ģʽ(����ģʽ������ģʽ)
	private static ProductDao instance;

	public synchronized static ProductDao getInstance() {
		if (instance == null) {
			instance = new ProductDao();
			//
		}
		return instance;
	}

	private ProductDao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ����������Ʒ����Ϣ
	 * 
	 * @return
	 */
	public List<ProductInfo> findAllProducts() {
		Connection conn = DBUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProductInfo> list = new ArrayList<ProductInfo>();
		try {
			stmt = conn.prepareStatement("select * from products");
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(convert2Info(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stmt, conn);
		}
		return list;
	}

	private ProductInfo convert2Info(ResultSet rs) throws SQLException {
		ProductInfo info = new ProductInfo();
		info.setPrdId(rs.getInt("product_id"));
		if (rs.getObject("product_type_id") != null)
			info.setTypeId(rs.getInt("product_type_id"));
		info.setPrdName(rs.getString("name"));
		info.setDesc(rs.getString("description"));
		if (rs.getObject("price") != null) {
			info.setPrice(rs.getInt("price"));
		}
		return info;
	}

	/**
	 * ��������Ʒ
	 * 
	 * @param info
	 */
	public int save(ProductInfo info) {
		Connection conn = DBUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			stmt = conn.prepareStatement("SELECT IFNULL(MAX(product_id),0) FROM products ");
			rs = stmt.executeQuery();
			if (rs.next()) {
				info.setPrdId(rs.getInt(1) + 1);
			}
			DBUtils.close(rs, stmt, null);
			stmt = conn.prepareStatement(
					"INSERT INTO products(product_id,product_type_id,NAME,description,price)" + " VALUES(?,?,?,?,?)");
			stmt.setInt(1, info.getPrdId());
			if (info.getTypeId() != null) {
				stmt.setInt(2, info.getTypeId());
			} else {
				stmt.setNull(2, Types.INTEGER);
			}
			stmt.setString(3, info.getPrdName());
			stmt.setString(4, info.getDesc());

			if (info.getPrice() != null) {
				stmt.setInt(5, info.getPrice());
			} else {
				stmt.setNull(5, Types.INTEGER);
			}
			count = stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtils.close(null, stmt, conn);
		}
		return count;
	}

	/**
	 * ������Ʒ���ɾ����Ʒ
	 * 
	 * @param prdId
	 * @return
	 */
	public int delete(Integer prdId) {
		Connection conn = DBUtils.getConnection();
		PreparedStatement stmt = null;
		int count = 0;
		try {
			stmt = conn.prepareStatement("DELETE FROM products WHERE product_id=?");
			stmt.setInt(1, prdId);
			count = stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtils.close(null, stmt, conn);
		}
		return count;
	}

	public ProductInfo findById(Integer prdId) {
		ProductInfo info = null;
		Connection conn = DBUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn.setReadOnly(true);
			stmt = conn.prepareStatement("SELECT p.`product_id`,p.`product_type_id`,p.`name`,p.`description`,p.`price` "
					+ "FROM products p " + "WHERE p.`product_id`=?");
			stmt.setInt(1, prdId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				info = this.convert2Info(rs);
			}
			conn.commit();
			conn.setReadOnly(false);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stmt, conn);
		}
		return info;
	}

	/**
	 * �༭��Ʒ��Ϣ
	 * 
	 * @param info
	 * @return
	 */
	public int edit(ProductInfo info) {
		Connection conn = DBUtils.getConnection();
		PreparedStatement stmt = null;
		int count = 0;
		try {
			stmt = conn.prepareStatement(
					"UPDATE products SET product_type_id=?,NAME=?,description=?,price=? " + "WHERE product_id=?");
			if (info.getTypeId() != null) {
				stmt.setInt(1, info.getTypeId());
			} else {
				stmt.setNull(1, Types.INTEGER);
			}
			stmt.setString(2, info.getPrdName());
			stmt.setString(3, info.getDesc());
			if (info.getPrice() != null) {
				stmt.setInt(4, info.getPrice());
			} else {
				stmt.setNull(4, Types.INTEGER);
			}
			stmt.setInt(5, info.getPrdId());
			count = stmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtils.close(null, stmt, conn);
		}
		return count;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBUtils;
import vo.ProductTypeInfo;

public class ProductTypeDao {
	// ����ģʽ(����ģʽ������ģʽ)
	private static ProductTypeDao instance;

	public synchronized static ProductTypeDao getInstance() {
		if (instance == null) {
			instance = new ProductTypeDao();
		}
		return instance;
	}

	private ProductTypeDao() {
	}

	public List<ProductTypeInfo> findAllTypes() {
		Connection conn = DBUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProductTypeInfo> list = new ArrayList<ProductTypeInfo>();
		try {
			stmt = conn.prepareStatement("select * from product_types");
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(convert2Info(rs));
			}
			conn.commit();
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
		return list;
	}

	private ProductTypeInfo convert2Info(ResultSet rs) throws SQLException {
		ProductTypeInfo info = new ProductTypeInfo();
		info.setTypeId(rs.getInt("product_type_id"));
		info.setTypeName(rs.getString("name"));
		return info;
	}
}

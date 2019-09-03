package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBUtils;
import vo.UserInfo;

public class UserDao {

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	private UserDao() {
	}

	/**
	 * �����˺Ż�ȡ�û���Ϣ
	 * 
	 * @param account
	 * @return
	 */
	public UserInfo findByAccount(String account) {
		Connection conn = DBUtils.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		UserInfo info = null;
		try {
			stmt = conn.prepareStatement("SELECT u.`user_id`,u.`user_account`,u.`user_password`,u.`user_name` "
					+ "FROM users u " + "WHERE u.`user_account`=?");
			stmt.setString(1, account);
			rs = stmt.executeQuery();
			if (rs.next()) {
				info = convert2Info(rs);
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
		return info;
	}

	private UserInfo convert2Info(ResultSet rs) throws SQLException {
		UserInfo info = new UserInfo();
		info.setUserId(rs.getInt("user_id"));
		info.setAccount(rs.getString("user_account"));
		info.setPwd(rs.getString("user_password"));
		info.setUserName(rs.getString("user_name"));
		return info;
	}
}

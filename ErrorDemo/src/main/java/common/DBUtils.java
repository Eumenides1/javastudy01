package common;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {

	private static BasicDataSource ds;
	

	public static void initConnectionPool(String url, String user, String pwd) {
		ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl(url);
		
		ds.setUsername(user);
		ds.setPassword(pwd);

		ds.setInitialSize(2);
		ds.setMaxActive(90);
		ds.setMaxIdle(3);
		ds.setMinIdle(1);
		ds.setMaxWait(5000);

		ds.setDefaultAutoCommit(false);
		System.out.println("���ݿ����ӳس�ʼ����ϡ�����");
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeConnectionPool() {
		if (ds != null) {
			try {
				ds.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("���ݿ����ӳعرա�����");
	}
}

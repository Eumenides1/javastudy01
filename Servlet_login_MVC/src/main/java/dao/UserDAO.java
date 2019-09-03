package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;

/**
 * 	DAO类：
 * 		用于封装数据访问逻辑
 *
 */
public class UserDAO {
	
	public User find(String username){
		User user = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM t_user "
					+ "WHERE username = ?";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(username);
				user.setPhone(rs.getString("phone"));
				user.setPwd(rs.getString("pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return user;
	}
	
	
	public void delete(int id){
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = 
					"DELETE FROM t_user WHERE id = ?";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConnection(conn);
		}
	}
	
	public void save(User user){
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "INSERT INTO t_user"
					+ "(username,pwd,phone) "
					+ "VALUES(?,?,?)";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConnection(conn);
		}
	}
	
	
	public List<User> findAll(){
		List<User> users = 
				new ArrayList<User>();
		
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM t_user";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String pwd = rs.getString("pwd");
				String phone = rs.getString("phone");
				
				User user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setPwd(pwd);
				user.setPhone(phone);
				
				users.add(user);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		return users;
	}
}









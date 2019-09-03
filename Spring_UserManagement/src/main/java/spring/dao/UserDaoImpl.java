package spring.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Repository;
import spring.bean.User;
import spring.util.DBUtils;

import javax.annotation.Resource;
import java.sql.*;

/**
 * @author Eumenides
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {

    @Resource(name = "dataSource")
    private BasicDataSource dataSource;

    @Override
    public Integer insert(User user) {
        //1.声明必要的变量
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO t_user(username,password,phone,email) VALUES(?,?,?,?)";
        Integer id = -1;
        //2.获取连接
        try {
            conn = dataSource.getConnection();
            //3.预编译SQL
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getPhone());
            pstmt.setString(4,user.getEmail());
            //4.执行SQL,如果可以获取返回值，则获取
            pstmt.executeUpdate();
            //5.处理结果，通常是因为执行的是select或insert
            rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //  6.释放资源
            DBUtils.close(conn,pstmt,rs);
        }

        return id;
    }

    @Override
    public User findUserByUsername(String username) {
        //1.声明必要的变量
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT ID,USERNAME,PASSWORD,PHONE,EMAIL FROM t_user WHERE username=?";
        User user = null;

        //2.获取连接
        try {
            conn = dataSource.getConnection();
            //3.预编译SQL
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            //4.执行，如果可以获取返回值，则获取
            rs = pstmt.executeQuery();
            //5.处理结果
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            DBUtils.close(conn,pstmt,rs);
        }

        return user;
    }
}

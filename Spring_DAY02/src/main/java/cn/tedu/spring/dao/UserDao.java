package cn.tedu.spring.dao;

import cn.tedu.spring.bean.User;

/**
 * @author Eumenides
 */
public class UserDao {

    /**
     * 增加用户数据到数据库
     * @param user
     * @return 新增数据的id
     */
    public int insert(User user){
        return 1;
    }

    /**
     * 根据用户名查询用户数据
     * @param username 用户名
     * @return 与用户名匹配的用户数据，如果查询失败，返回null
     */
    public User findUserByUserName(String username){
        //以下是模拟数据
        if("admin".equals(username)){
            User user = new User();
            user.setUsername("admin");
            user.setPassword("123");
            return user;
        }
        return null;
    }
}

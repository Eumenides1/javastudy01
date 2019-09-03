package spring.dao;

import spring.bean.User;

/**
 * @author Eumenides
 */
public interface IUserDao {
    /**
     * 增加用户数据
     * @param user
     * @return 新增加的用户ID,若增加失败，则返回-1
     */
    Integer insert(User user);

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 查询到的用户数据，如果没有查到匹配的记录，则返回null
     */
    User findUserByUsername(String username);


}

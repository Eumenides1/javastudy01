package spring.service;

import spring.bean.User;

/**
 * @author Eumenides
 */
public interface IUserService {
    /**
     * 注册新用户
     * @param user 新用户的信息
     * @return 新用户的ID，如果注册失败，则返回-1
     */
    Integer register(User user);
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 查询到的用户数据，如果没有查到匹配的记录，则返回null
     */
    User findUserByUsername(String username);


}

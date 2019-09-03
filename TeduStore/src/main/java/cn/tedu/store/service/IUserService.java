package cn.tedu.store.service;

import cn.tedu.store.bean.User;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UsernameAlreadyExistsException;
import cn.tedu.store.service.ex.UsernameNotFoundException;

public interface IUserService {
    /**
     * 增加用户数据
     *
     * @param user
     *            新的用户数据
     * @return 新增加的数据的ID
     * @throws UsernameAlreadyExistsException 当注册的用户名已经被占用时抛出该异常
     */
    Integer register(User user);

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     *            用户名
     * @return 与用户名匹配的用户数据，如果没有匹配的数据，则返回null
     */
    User findUserByUsername(String username);

    /**
     * 根据用户id查询用户信息
     *
     * @param id
     *
     * @return 与用户id匹配的用户数据，如果没有匹配的数据，则返回null
     */
    User findUserById(Integer id);

    /**
     * 检查某电子邮箱是否已经在数据表中存在
     * @param email
     * @return
     */
    boolean checkEmailExists(String email);

    /**
     * 检查某电子邮箱是否已经在数据表中存在
     * @param phone
     * @return
     */
    boolean checkPhoneExists(String phone);
    /**
     * 检查某用户名是否已经在数据表中存在
     * @param username
     * @return
     */
    boolean checkUsernameExists(String username);

    /**
     * 用户登录
     * @param username 用户名
     * @param password  密码
     * @throws UsernameNotFoundException
     * @throws PasswordNotMatchException
     * @return User 登录成功，返回User对象
     */
    User login(String username,String password);

    /**
     *  修改用户密码
     * @param uid   被修改的用户的id
     * @param oldPassword   原密码
     * @param newPassword   新密码
     * @return 受影响的行数
     * @throws UsernameNotFoundException 用户信息不存在
     * @throws PasswordNotMatchException 原密码不正确
     */
    Integer changePassword(Integer uid,
                           String oldPassword,
                           String newPassword);

    /**
     * 修改用户基本资料
     * @param uid   用户ID
     * @param username 用户名
     * @param gender 用户性别
     * @param phone 联系电话
     * @param email 电子邮件
     * @return  受影响的行数
     * @throws UsernameNotFoundException 用户信息不存在
     */
    Integer editProfile(Integer uid,
                String username,
                Integer gender,
                String phone,
                String email);

}

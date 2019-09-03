package SSM.service;

import SSM.Bean.User;

import java.util.List;

public interface IUserService {

    /**
     * 用户注册
     * @param user 新用户的数据
     * @return
     */
    Integer register(User user);

    /**
     * 根据用户名查询用户数据
     * @param username
     * @return
     */
    User findUserByUsername(String username);

    /**
     * 根据id查找用户数据
     * @param id
     * @return
     */
    User findUserByID(Integer id);

    /**
     * 查询所有用户数据
     * @return
     */
    List<User> findAllUser();

    /**
     * 根据用户的ID删除数据
     * @param id
     * @return 如果删除成功，返回1；删除失败，返回0
     */
    Integer delete(Integer id);

    /**
     * 修改用户数据（不支持修改用户名）
     * @param user
     * @return
     */
    Integer updateUserInfo(User user);

    /**
     * 修改用户数据
     *
     * @param user 应该封装了被修改的用户id，
     * @return
     */
    Integer update(User user);
}

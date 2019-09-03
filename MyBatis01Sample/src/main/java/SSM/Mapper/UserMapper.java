package SSM.Mapper;

import SSM.Bean.User;

import java.util.List;

public interface UserMapper {
    /**
     * 创建用户数据
     * @param user
     * @return 受影响的行数
     *      如果需要获取新数据的ID
     *      可以在调用本方法后，从
     *      参数对象中获取
     */
    Integer createUser(User user);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 与用户名匹配的用户数据，如果没有则返回null
     */
    User findUserByUsername(String username);

    /**
     * 根据用户ID查询用户数据
     * @param id
     * @return 与ID匹配的用户数据
     */
    User findUserByID(Integer id);

    /**
     * 查询所有用户信息
     * @return 查询到的数据集合
     */
    List<User> findAllUser();

    /**
     * 根据id删除相应用户
     * @param id
     * @return
     */
    Integer deleteById(Integer id);


    Integer updateUserInfo(User user);

    Integer updateUserInfo2(User user);
}

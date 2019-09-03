package SSM.mapper;

import SSM.Bean.User;

public interface UserMapper {

    /**
     * 增加用户数据
     * @param user
     */
    void insert(User user);

    /**
     * 根据用户名查询数据
     *
     * @param username
     * @return
     */
    User findUserByUsername(String username);


}


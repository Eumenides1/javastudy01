package SSM.service;

import SSM.Bean.User;

public interface IUserService {
    /**
     * 根据用户名进行查询
     * @param username
     * @return
     */
    User findUserByUsername(String username);


    /**
     *  注册新用户
     * @param user
     * @return 新用户的ID
     * @throws SSM.service.ex.UsernameAlreadyExistsException
     */
    Integer register(User user);

}

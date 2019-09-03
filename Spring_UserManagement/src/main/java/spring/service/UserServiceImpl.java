package spring.service;

import org.springframework.stereotype.Service;
import spring.bean.User;
import spring.dao.IUserDao;

import javax.annotation.Resource;

/**
 * @author Eumenides
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource(name = "userDao")
    private IUserDao userDao;

    @Override
    public Integer register(User user) {
        //1.查询新用户的用户名在数据表中对应的数据
        User u = findUserByUsername(user.getUsername());
        //2.判断查询结果
        if (u == null) {
            //查询结果为null，表示用户名还未被注册
            return userDao.insert(user);
        } else {
            return -1;
        }
        }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

}

package cn.tedu.spring.Service;

import cn.tedu.spring.Service.ex.PasswordNotMatchException;
import cn.tedu.spring.Service.ex.UserNameNotExistsException;
import cn.tedu.spring.Service.ex.UsernameAlreadyExistsException;
import cn.tedu.spring.bean.User;
import cn.tedu.spring.dao.UserDao;
import sun.security.util.Password;

/**
 * @author Eumenides
 */
public class UserService {
    /**
     * UserDao的对象
     * 即访问持久层（通常是数据库）的对象
     */
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 注册
     * @param user 尝试注册的用户信息
     * @throws UsernameAlreadyExistsException 当用户名已经被注册时常抛出此异常
     */
    public void reg(User user) throws UsernameAlreadyExistsException {
        //检查用户名是否被注册
        User u = userDao.findUserByUserName(user.getUsername());
        if(u == null){
            //没有匹配数据，即用户名没有被注册，所以允许注册
            userDao.insert(user);
        }else{
            //查询到匹配的数据，即用户名被注册，此次，不允许注册
            throw new UsernameAlreadyExistsException("用户名已经被占用");
        }
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @throws UserNameNotExistsException 用户名不存在
     * @throws PasswordNotMatchException 密码不匹配
     */
    public void login(String username,String password) throws UserNameNotExistsException, PasswordNotMatchException {
        //根据用户名查询用户数据
        User u = userDao.findUserByUserName(username);
        if( u == null){
            throw new UserNameNotExistsException("用户名不存在");
        }else{
            //用户名存在，判断密码
            if(u.getPassword().equals(password)){
                //密码匹配，则登录成功
            }else{
                //密码不匹配，则登陆失败
                throw new PasswordNotMatchException("密码错误");
            }
        }

    }
}

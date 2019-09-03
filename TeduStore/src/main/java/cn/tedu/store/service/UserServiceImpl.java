package cn.tedu.store.service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExistsException;
import cn.tedu.store.service.ex.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("userService")
public class UserServiceImpl implements IUserService{

    @Resource(name="userMapper")
    private UserMapper userMapper;


    @Override
    public Integer register(User user) {
        //获取新用户在数据表中对应的数据

        //是否获取到数据
        if(checkUsernameExists(user.getUsername())){
            //查询不到匹配的数据
            //则用户尚未被注册，允许此次注册
            throw new UsernameAlreadyExistsException("用户名已存在！");

        } else {

            userMapper.insert(user);

            return user.getId();

        }
    }

    @Override
    public User login(String username, String password) {
        //根据用户名获取用户数据
        User user = findUserByUsername(username);
        if(user != null){
            //数据不为Null,即查询到了数据
            //则判断密码
            if(user.getPassword().equals(password)){
                //匹配，则登录成功
                return user;
            }else {
                //密码不匹配，抛出异常
                throw new PasswordNotMatchException("密码错误");
            }

        }else {
            //数据为null，即根据用户名查找不到有效数据
            //用户名不存在
            throw new UsernameNotFoundException("用户名不存在");
        }
    }

    @Override
    public Integer changePassword(Integer uid, String oldPassword, String newPassword) {
        User user = findUserById(uid);
        if(user == null){
            //用户数据不存在
            throw new UserNotFoundException("用户数据不存在，可能已经被删除！请联系管理员");
        }else {
            //用户名存在
            if(user.getPassword().equals(oldPassword)){
                //原密码匹配
                //创建User对象
                User newUser = new User();
                //将uid和newPassword封装
                newUser.setId(uid);
                newUser.setPassword(newPassword);
                return userMapper.update(newUser);
            }else {
                throw new PasswordNotMatchException("原密码错误");
            }
        }
    }

    @Override
    public Integer editProfile(Integer uid,
                               String username,
                               Integer gender,
                               String phone,
                               String email) {
        User user = new User();
        //根据Uid查询用户信息
        User u = userMapper.findUserById(uid);
        if(u == null){
            throw new UserNotFoundException("登陆已经过期");
        }
        //用户数据存在，则判断新用户名与现有用户名是否一致
        if(u.getUsername().equals(username)){
            //一致,新用户名就是现有用户名，无需修改
        }else {
            //提交的是新用户名，判断是否被占用
            User u2 = findUserByUsername(username);
            if(u2 == null){
                //没有被占用，可以修改用户名
                user.setUsername(username);
            }else{
                //新用户名有匹配
                if(u2.getId().equals(uid)){
                    //匹配，用户名未改变
                }else {
                    //找到新用户名存在的数据
                    throw  new UsernameAlreadyExistsException();
                }
            }
        }
        //2.封装性别
        user.setGender(gender);
        //3.封装手机号码
        if(phone != null && phone.length()>=11){
            user.setPhone(phone);
        }

        //4.封装电子邮箱
        user.setEmail(email);
        //*** 封装uid
        user.setId(uid);
        //封装修改日志数据
        user.setModifiedUser("[System]");
        user.setModifiedTime(new Date());


        //5.执行修改
        return userMapper.update(user);

    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public boolean checkEmailExists(String email) {
        return userMapper.getRecordCountByEmail(email)>0;
    }

    @Override
    public boolean checkPhoneExists(String phone) {
        return userMapper.getRecordCountByPhone(phone)>0;
    }

    @Override
    public boolean checkUsernameExists(String username) {
        return findUserByUsername(username) != null;
    }


}

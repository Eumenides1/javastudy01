package SSM.service;

import SSM.Bean.User;
import SSM.Mapper.UserMapper;
import SSM.service.Exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService{

    @Resource
    private UserMapper userMapper;


    @Override
    public Integer register(User user) {
        return userMapper.createUser(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public User findUserByID(Integer id) {
        return userMapper.findUserByID(id);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public Integer delete(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Integer updateUserInfo(User user) throws UserNotFoundException{
        //检查ID是否正常
        if(user.getId() == null || user.getId()<=0){
            throw new IllegalArgumentException("用户ID错误："+user.getId());
        }
        //根据ID查询用户
        User u = findUserByID(user.getId());
        //判断是否查询到匹配的用户信息
        if(u == null){
            //查询结果为null，即ID没有匹配的用户数据
            throw new UserNotFoundException("根据ID没有查询到匹配的用户数据："
                    +user.getId());
        }
        //查询到匹配的用户数据
        //则开始检查参数，是否需要将其中某些属性赋值
        if (user.getPassword()==null){
            user.setPassword(u.getPassword());
        }
        if (user.getPhone()==null){
            user.setPhone(u.getPhone());
        }
        if(user.getEmail()==null){
            user.setEmail(u.getEmail());
        }

        return userMapper.updateUserInfo(user);
    }

    @Override
    public Integer update(User user) {
        return null;
    }
}

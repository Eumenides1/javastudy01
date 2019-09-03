package SSM.service;

import SSM.Bean.User;
import SSM.mapper.UserMapper;
import SSM.service.ex.UsernameAlreadyExistsException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl  implements IUserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {

        return userMapper.findUserByUsername(username);
    }

    @Override
    public Integer register(User user) {
        //获取新用户在数据表中对应的数据
        User u = findUserByUsername(user.getUsername());
        //是否获取到数据
        if(u == null){
            //查询不到匹配的数据
            //则用户尚未被注册，允许此次注册
            userMapper.insert(user);
            //获取id
            Integer id = user.getId();
            //返回id
            return id;
        } else {
            //查询到匹配的数据
            //则用户名已经被注册，不允许此次注册
            throw new UsernameAlreadyExistsException("用户名已存在！");
        }

    }
}

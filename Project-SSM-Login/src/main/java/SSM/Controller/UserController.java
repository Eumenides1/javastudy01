package SSM.Controller;

import SSM.Bean.ResponseResult;
import SSM.Bean.User;
import SSM.service.IUserService;
import SSM.service.ex.UsernameAlreadyExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/register.do")
    public String showRegister(){

        return "/register.jsp";
    }

    @RequestMapping("/check_username.do")
    @ResponseBody
    public ResponseResult<Void> checkUsername(String username){
        ResponseResult<Void> rr;
        User u = userService.findUserByUsername(username);
        if(u == null){
            rr = new ResponseResult<>(1,"用户名可以注册");
        }else {
            rr = new ResponseResult<>(0,"用户名已存在");
        }
        return rr;
    }

    @RequestMapping(value = "/handle_register.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Void> handleRegister(User user){
        ResponseResult<Void> rr;
        Integer id = userService.register(user);
        try {
            rr = new ResponseResult<>(1,"注册成功,用户ID为:"+id);
        }catch (UsernameAlreadyExistsException e){
            rr = new ResponseResult<>(0,e.getMessage());
        }
        return rr;
    }

}

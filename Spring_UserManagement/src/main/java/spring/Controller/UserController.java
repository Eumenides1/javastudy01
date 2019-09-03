package spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.bean.User;
import spring.service.IUserService;

import javax.annotation.Resource;

/**
 * @author Eumenides
 */
@Controller
public class UserController {
    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/handleRegister.do")
    public String handleRegister(User user, ModelMap modelMap){
        //执行注册
        Integer id = userService.register(user);
        if(id == -1){
            //注册失败，先封装需要转发的数据
            modelMap.addAttribute("errorMessage","用户名已经存在，注册失败");
            //执行转发
            return "error";
        }else {
            //注册成功
            return "redirect:login.do";
        }

    }

    @RequestMapping("/register.do")
    public String showRegister(){

        return "register";
    }
    @RequestMapping("/login.do")
    public String showLogin(){

        return "login";
    }

}

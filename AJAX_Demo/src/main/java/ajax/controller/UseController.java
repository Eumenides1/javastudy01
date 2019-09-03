package ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UseController {

    @RequestMapping("/login.do")
    public String showLogin(){
        return "login";
    }

    @RequestMapping(value = "handle_login.do",method = RequestMethod.POST)
    @ResponseBody
    public String handleLogin(String username,String password){
        System.out.println(username);
        System.out.println(password);
        if("ajax".equals(username) & "ajax888".equals(password)){
            return "1";
        } else {
            return "0";
        }
    }
    @RequestMapping(value = "check_username.do",method = RequestMethod.POST)
    @ResponseBody
    public String checkUsername(String username){
        System.out.println(username);
        if("ajax".equals(username)){
            return "{\"state\":\"1\",\"message\":\"用户名正确!\"}";
        }else {
            return "{\"state\":\"0\",\"message\":\"用户名错误!\"}";
        }
    }
}

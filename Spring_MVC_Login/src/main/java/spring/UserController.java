package spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eumenides
 */
@Controller
public class UserController {

    @RequestMapping("/login.do")
    public String showLogin(){

        return "login";
    }

    @RequestMapping("/handleLogin.do")
    public String handleLogin(String username, String password, ModelMap modelMap){
        //声明登录结果
        String result;
        //判断用户名
        if("tomcat".equals(username)){
            //用户名正确，判断密码
            if("123456".equals(password)){
                //登录成功
                result = "登录结果：登陆成功！";
            }else {
                //密码错误
                result = "密码错误，登录失败";
            }
        }else {
            //用户名错误
            result = "用户名不存在，登录失败";
        }

        //将需要转发的数据封装到modelMap中
        modelMap.addAttribute("result",result);
        //执行转发
        return "login_result";
    }

//    @RequestMapping("/handleLogin.do")
//    public ModelAndView handleLogin(String username,String password){
//        //声明登录结果
//        String result;
//        //判断用户名
//        if("tomcat".equals(username)){
//            //用户名正确，判断密码
//            if("123456".equals(password)){
//                //登录成功
//                result = "登陆成功！";
//            }else {
//                //密码错误
//                result = "密码错误，登录失败";
//            }
//        }else {
//            //用户名错误
//            result = "用户名不存在，登录失败";
//        }
//        //将result封装以转发到jsp
//        String viewName = "login_result";
//
//        Map<String,Object> model = new HashMap<>();
//
//        model.put("result",result);
//
//        ModelAndView mov = new ModelAndView(viewName,model);
//
//        //返回，执行转发
//        return mov;
//    }
}

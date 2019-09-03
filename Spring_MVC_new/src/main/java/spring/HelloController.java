package spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eumenides
 */
@Controller
public class HelloController {

    @RequestMapping("/hello.do")
    public String showHello(){
//        //创建ModelAndView
//        ModelAndView mav = new ModelAndView();
//        //指定View组件名
//        mav.setViewName("hello");
//        //返回
        return "hello";

    }
    @RequestMapping("/login.do")
    public String showLogin(){
        return "login";
    }

}

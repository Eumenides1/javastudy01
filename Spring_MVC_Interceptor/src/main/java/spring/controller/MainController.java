package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eumenides
 */
@Controller
public class MainController {

    @RequestMapping("/index.do")
    public String showIndex(){
        return "index";
    }
    @RequestMapping("/login.do")
    public String showLogin(){
        return "login";
    }
    @RequestMapping("/use_center.do")
    public String showUserCenter(){
        return "use_center";
    }
}

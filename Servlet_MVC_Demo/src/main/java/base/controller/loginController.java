package base.controller;

import base.annotation.RequestMapping;
import base.web.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;

/**
 * 模型
 * @author Eumenides
 */

public class loginController {
    @RequestMapping("/toLogin.do")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login.do")
    public String login(HttpServletRequest request){
        System.out.println("request:"+request);
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        return "redirect:welcome.do";
    }
}

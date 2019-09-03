package base.controller;

import base.annotation.RequestMapping;

/**
 * 模型
 * @author Eumenides
 */
public class HelloController {
    /**
     * 返回值我们称之为视图名，
     * 注：
     *      视图名会对应一个jsp，这个对应关系由控制器来负责
     * @return
     */
    @RequestMapping("/hello.do")
    public String hello(){
        System.out.println("Hellocontroller's hello()");
        return "hello";
    }
    @RequestMapping("/welcome.do")
    public String welcome(){
        System.out.println("HelloCOntroller's welcome()");
        return "welcome";
    }
    @RequestMapping("/hello2.do")
    public String hello2(){
        System.out.println("Hellocontroller's hello2()");
        //重定向
        return "redirect:welcome.do";
    }
}

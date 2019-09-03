package cn.tedu.spring.main;

import cn.tedu.spring.Service.UserService;
import cn.tedu.spring.Service.ex.PasswordNotMatchException;
import cn.tedu.spring.Service.ex.UserNameNotExistsException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Eumenides
 */
public class Sample {
    public static void main(String[] args) {
        //加载XML配置，获取Spring容器
        String fileName = "applicationcontext.xml";
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(fileName);
        //创建UserService对象
        UserService userService = ac.getBean("UserService",UserService.class);
        //模拟登录的数据
        String username = "admin";
        String password = "123456";
        //测试登录功能
        try {
            userService.login(username,password);
            System.out.println("登陆成功");
        } catch (UserNameNotExistsException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        } catch (PasswordNotMatchException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }finally {
            ac.close();
            System.out.println("程序运行结束");

        }
    }
}

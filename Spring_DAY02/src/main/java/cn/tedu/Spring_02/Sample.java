package cn.tedu.Spring_02;

import cn.tedu.spring.bean.User;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Eumenides
 */
public class Sample {
    public static void main(String[] args) {
        //加载Spring配置文件
        String fileName = "applicationContext.xml";
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(fileName);
        //获取UserService对象
        UserService userService = ac.getBean("userService",UserService.class);

        userService.reg();




        //释放资源
        ac.close();
    }
}

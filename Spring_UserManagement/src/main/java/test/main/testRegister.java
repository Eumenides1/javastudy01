package test.main;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean.User;
import spring.dao.IUserDao;
import spring.service.IUserService;

/**
 * @author Eumenides
 */
public class testRegister {
    @Test
    public void testfindUserByUsername(){
        //1.加载Spring配置，获取Spring容器
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
        //2.获取IUserService对象
        IUserService userService = ac.getBean("userService", IUserService.class);
        //3.测试功能
        User user = new User(0,"admin2","123456","13800138001","1763077056@qq.com");
        Integer uid = userService.register(user);
        System.out.println("增加用户完成，返回的是："+uid);
        //4.释放资源
        ac.close();
    }
}

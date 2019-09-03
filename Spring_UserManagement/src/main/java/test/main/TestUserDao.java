package test.main;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean.User;
import spring.dao.IUserDao;

/**
 * @author Eumenides
 */
public class TestUserDao {
    @Test
    public void testInsert(){
        //1.加载Spring配置，获取Spring容器
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
        //2.获取IUserDao对象
        IUserDao userDao = ac.getBean("userDao", IUserDao.class);
        //3.测试功能
        User user = new User(0,"admin2","123456","13800138001","1763077056@qq.com");
        Integer uid = userDao.insert(user);
        System.out.println("增加用户完成，返回的是："+uid);
        //4.释放资源
        ac.close();
    }
    @Test
    public void testfindUserByUsername(){
        //1.加载Spring配置，获取Spring容器
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
        //2.获取IUserDao对象
        IUserDao userDao = ac.getBean("userDao", IUserDao.class);
        //3.测试功能
       String username = "SPRING";
       User user = userDao.findUserByUsername(username);
        System.out.println(user);
        //4.释放资源
        ac.close();
    }
}

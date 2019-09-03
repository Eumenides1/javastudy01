package Tester;

import SSM.Bean.User;
import SSM.Mapper.UserMapper;
import SSM.service.IUserService;
import SSM.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {

    @Test
    public void testDaoInsert(){
        //1.加载Spring容器
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc.xml");
        //2.获取对象
        UserMapper userMapper = ctx.getBean("userMapper",UserMapper.class);
        //3.执行
        User user = new User();
        user.setUsername("CSS3");
        user.setPassword("789456");
        user.setPhone("13344445555");
        user.setEmail("CSS3@tedu.com");
        userMapper.createUser(user);
        Integer id = user.getId();
        System.out.println("i:"+id);
        //4.释放资源
        ctx.close();
    }

    @Test
    public void testMapperFindUser(){
        //1.加载Spring容器
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc.xml");
        //2.获取对象
        UserMapper userMapper = ctx.getBean("userMapper",UserMapper.class);
        //3.执行
        String username = "CSS3";
        User user = userMapper.findUserByUsername(username);
        System.out.println(user);
        //4.释放资源
        ctx.close();
    }
    @Test
    public void testMapperFindAllUser(){
        //1.加载Spring容器
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc.xml");
        //2.获取对象
        UserMapper userMapper = ctx.getBean("userMapper",UserMapper.class);
        //3.执行
        List<User> users = userMapper.findAllUser();
        for (User user :
                users) {
            System.out.println(user);
        }
        ctx.close();
    }

    @Test
    public void testDeleteData(){
        //1.加载Spring容器
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc.xml");
        //2.获取对象
        UserMapper userMapper = ctx.getBean("userMapper",UserMapper.class);
        //3.执行
        Integer i = userMapper.deleteById(5);
        System.out.println(i);
        ctx.close();
    }
    @Test
    public void updateUserInfo(){
        //1.加载Spring容器
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc.xml");
        //2.获取对象
        UserMapper userMapper = ctx.getBean("userMapper",UserMapper.class);
        //3.执行
        User user = new User();
        user.setId(2);
        user.setPassword("666888");
        user.setPhone("13900139002");
        user.setEmail("miao@tedu,com");
        Integer affecteRow = userMapper.updateUserInfo(user);
        System.out.println(affecteRow);
        //4.释放资源
        ctx.close();
    }
    @Test
    public void testServiceUpdate(){
        //1.加载Spring容器
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc.xml");
        //2.获取对象
        IUserService userService = ctx.getBean("userService", IUserService.class);
        //3.执行
        User user = new User();
        user.setId(2);
        user.setPassword("777888");
        //user.setPhone("99886655331");
        user.setEmail("wang@tedu.com");

        Integer affectedRows = userService.updateUserInfo(user);
        System.out.println(affectedRows);


    }
    @Test
    public void updateUserInfo2(){
        //1.加载Spring容器
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc.xml");
        //2.获取对象
        UserMapper userMapper = ctx.getBean("userMapper",UserMapper.class);
        //3.执行
        User user = new User();
        user.setId(2);
        user.setPassword("123456");
        //user.setPhone("13900139012");
        user.setEmail("MySQl@tedu,com");
        Integer affecteRow = userMapper.updateUserInfo2(user);
        System.out.println(affecteRow);
        //4.释放资源
        ctx.close();
    }

}

import SSM.Bean.User;
import SSM.mapper.UserMapper;
import SSM.service.IUserService;
import SSM.service.ex.UsernameAlreadyExistsException;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {

    @Test
    public void testDaoInsert(){
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc.xml");
        UserMapper userMapper = ctx.getBean("userMapper",UserMapper.class);

        User user = new User();
        user.setUsername("ajax");
        user.setPassword("000000");
        userMapper.insert(user);

        ctx.close();

    }

    @Test
    public void testfindUser(){
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc.xml");
        UserMapper userMapper = ctx.getBean("userMapper",UserMapper.class);

        User user = userMapper.findUserByUsername("ajax");
        System.out.println(user);
        ctx.close();

    }
    @Test
    public void testServiceRegister(){
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc.xml");
        IUserService userService = ctx.getBean("userService",IUserService.class);

        User user = new User();
        user.setUsername("ajax");
        user.setPassword("334334");
        Integer id = null;

        try {
            id = userService.register(user);
            System.out.println("id="+id);
        }catch (UsernameAlreadyExistsException e){
            System.err.println(e.getMessage());
        }

    }
}

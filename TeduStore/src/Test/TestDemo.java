import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExistsException;
import cn.tedu.store.service.ex.UsernameNotFoundException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class TestDemo {

    @Test
    public void testInsert(){
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper userMapper = ctx.getBean("userMapper",UserMapper.class);

        User user = new User();
        user.setUsername("Spring");
        user.setPassword("s3clet");
        userMapper.insert(user);

        System.out.println("增加数据完成："+user);

        User u = userMapper.findUserByUsername(user.getUsername());
        System.out.println("查询用户："+u);

        ctx.close();


    }
    @Test
    public void testServiceRegister() {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
        IUserService userService = ctx.getBean("userService", IUserService.class);

        User user = new User();
        user.setUsername("ajax100o");
        user.setPassword("334334");
        Integer id = null;

        try {
            id = userService.register(user);
            System.out.println("id=" + id);
        } catch (UsernameAlreadyExistsException e) {
            System.err.println(e.getMessage());
        }


    }
    @Test
    public void testServiceLogin(){
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
        IUserService userService = ctx.getBean("userService", IUserService.class);

        try{
            String username = "eumen";
            String password = "741852";
            User user = userService.login(username,password);
            System.out.println("登录成功，user="+user);
        }catch (UsernameNotFoundException e){
            System.err.println(e.getMessage());
        }catch (PasswordNotMatchException e){
            System.err.println(e.getMessage());
        }

    }
    @Test
    public void testUpdatePassword(){
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
        IUserService userService = ctx.getBean("userService", IUserService.class);

        try{
            Integer uid = 4;
            String oldPassword = "7418526";
            String newPassword = "888888";
            Integer affectedRows
                    = userService.changePassword(uid,oldPassword,newPassword);
            System.out.println(affectedRows);
        }catch (UserNotFoundException e){
            System.err.println(e.getMessage());
        }catch (PasswordNotMatchException e){
            System.err.println(e.getMessage());
        }

    }
    @Test
    public void testEditProfile(){
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
        IUserService userService = ctx.getBean("userService", IUserService.class);

        try{
            //3 ajax password
            Integer uid = 3;
            String username = "ajax2";
            Integer gender = 1;
            String phone = "17391508190";
            String email = "1763077056@qq.com";

            Integer affectedRows
                    = userService.editProfile(uid,username,gender,phone,email);
            System.out.println(affectedRows);
        }catch (UserNotFoundException e){
            System.err.println(e.getMessage());
        }catch (UsernameAlreadyExistsException e){
            System.err.println(e.getMessage());
        }

    }
}

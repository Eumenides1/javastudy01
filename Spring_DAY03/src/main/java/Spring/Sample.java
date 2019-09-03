package Spring;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Eumenides
 */
public class Sample {
    public static void main(String[] args) {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");


        UserService userService = ac.getBean("userService",UserService.class);

        userService.reg();


        ac.close();
    }
}

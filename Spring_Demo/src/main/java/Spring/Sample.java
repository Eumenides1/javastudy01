package Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Eumenides
 */
public class Sample {
    //请写出Java程序的入口函数的Signature(签名)
    public static void main(String[] args) {
        //普通的创建对象的方式
        Date date = new Date();
        System.out.println(date);

        Calendar cal = Calendar.getInstance();
        System.out.println(cal);

        /**
         * 使用Spring创建对象
         */
        //1.确定配置文件：文件名区分大小写
        String fileName = "applicationcontext.xml";
        //2.加载配置文件，获取Spring容器
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(fileName);
        //3.根据XML配置的id名称，从Spring容器中获取对象
        Date d = ac.getBean("date",Date.class);
        //4.测试
        System.out.println("从Spring容器中获取的id=date的对象:"+d);
        //5.测试2
        Calendar c = (Calendar) ac.getBean("calendar");
        System.out.println(" "+c);
        //6.测试
        Phone p = (Phone) ac.getBean("Phone");
        System.out.println(p.hashCode());

        //释放资源
        ac.close();
    }
}

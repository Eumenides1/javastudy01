package Spring_List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Eumenides
 */
public class Sample {
    public static void main(String[] args) {
        //加载Spring配置，获取Spring容器
        String fileName = "applicationcontext.xml";
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(fileName);

        SampleBean sampleBean = ac.getBean("sampleBean",SampleBean.class);
        System.out.println(sampleBean.getProvinces().getClass());

        System.out.println(sampleBean.getCity());

        System.out.println(sampleBean.getSession());

        System.out.println(sampleBean.getDBconfig());

        Student student = ac.getBean("stu",Student.class);
        System.out.println(student);


        ac.close();

    }
}

package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author Eumenides
 */
public class testCase3 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Scanner scan = new Scanner(System.in);
        //动态读取类名
        String className = scan.nextLine();
        System.out.println("className:"+className);
        //完成类的加载
        Class aclass= Class.forName(className);
        //实例化对象
        Object obj = aclass.newInstance();
        //获得所有方法
        Method[] mh = aclass.getDeclaredMethods();
        for (Method m :
                mh) {
            //只执行带有@Test注解的方法
            /**
             * 获得方法前的注解
             */
            Test test = m.getAnnotation(Test.class);

            if(test != null){
                //获得注解的属性值
                String prop = test.value();
                //该方法带有@Text注解，则执行
                System.out.println("prop:"+prop);
                m.invoke(obj);
            }
        }
    }
}

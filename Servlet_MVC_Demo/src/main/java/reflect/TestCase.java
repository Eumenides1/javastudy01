package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author Eumenides
 */
public class TestCase {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Scanner scan = new Scanner(System.in);
        //动态读取类名
        String className = scan.nextLine();
        System.out.println("className:"+className);
        /**
         * 类加载器（即ClassLoader,它是JVM提供的一个特殊对象）
         * 依据类名，找到类的字节码文件，然后读取字节码文件的内容，并
         * 将其存放到方法区中的对应的class对象里面
         */
        Class aclass= Class.forName(className);
        //创建类的实例
        Object obj = aclass.newInstance();
        /*
         * 获得该类的所有方法
         */
        Method[] methods = aclass.getDeclaredMethods();
        for(Method mh : methods){
            //获得方法的名称
            String mName = mh.getName();
            System.out.println("mName:"+mName);
            //返回值
            Object returnVal;
            //执行各个方法
            if("hello".equals(mName)){
                //执行带参的方法
                Object[] ags = new Object[]{"Sally"};
                returnVal = mh.invoke(obj,ags);
            }else {
                returnVal = mh.invoke(obj);
            }
            System.out.println("返回值:"+returnVal);
        }
    }
}

package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author Eumenides
 */
public class testCase2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Scanner scan = new Scanner(System.in);
        //动态读取类名
        String className = scan.nextLine();
        System.out.println("className:"+className);

        Class aclass= Class.forName(className);
        //创建类的实例
        Object obj = aclass.newInstance();
        /*
         * 获得该类的所有方法
         */
        Method[] methods = aclass.getDeclaredMethods();
        for (Method mh: methods) {
            if(mh.getName().startsWith("test")){
                mh.invoke(obj);
            }
        }
    }
}

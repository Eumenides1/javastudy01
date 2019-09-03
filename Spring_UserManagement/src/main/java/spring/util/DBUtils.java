package spring.util;

/**
 * 释放资源
 * @author Eumenides
 */
public class DBUtils {
    /**
     * 释放资源
     * @param obj 需要关闭的资源
     */
    public static void close(AutoCloseable... obj){
        for (int i = 0; i < obj.length; i++) {
            if(obj[i] != null){
                try {
                    obj[i].close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

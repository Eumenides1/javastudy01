package base.common;

import base.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 建立请求路径与模型的对应关系
 * （比如/hello.do应该由HelloController的
 * Hello方法来处理)
 * 该工作我们交给HandlerMapping来处理
 *
 * @author Eumenides
 */
public class HandlerMapping {

    //urlMap用于存放请求路径与模型的对应关系
    private Map<String,URLHandler> urlMap = new HashMap<String, URLHandler>();

    /**
     * beans:存放模型的集合
     * 遍历整个集合，对于某个bean，利用java反射读取存放到@RequestMapping上的路径
     * 然后建立请求对象与模型之间的对应关系
     * @param beans
     */
    public void process(List beans){
        for (Object obj : beans) {
            //获得所有方法（Method)
            Class aClass = obj.getClass();
            Method[] methods = aClass.getDeclaredMethods();
            //获得方法上的注解
            for(Method mh:methods){
                RequestMapping rm = mh.getAnnotation(RequestMapping.class);
                //如果说方法上没有注解，则该方法不是一个用于处理请求的方法
                if(rm == null){
                    continue;
                }
                //获得注解上的路径
                String path = rm.value();
                //将路径与模型的对应关系添加到urlMap上
                urlMap.put(path,new URLHandler(obj,mh));
            }
        }
        System.out.println("urlMap:"+urlMap);
    }

    /**
     * 依据请求路径找到对应的模型
     * @param path
     * @return
     */
    public URLHandler getURLHandler(String path){
        return urlMap.get(path);
    }





}

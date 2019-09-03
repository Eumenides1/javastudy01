package web;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 用于统计在线人数的监听器：
 * 思路：
 *      通过监听session的创建和销毁
 * @author Eumenides
 */
@WebListener
public class CountListener  implements HttpSessionListener {
    /**
     * session对象创建后执行
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated()");

        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();

        Integer count = (Integer) context.getAttribute("count");
        if(count == null){
            //第一个用户
            count = 1;
        }else {
            //不是第一个用户
            count++;
        }
        context.setAttribute("count",count);
    }

    /**
     * session对象销毁之后执行
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestroyed()");

        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        Integer count = (Integer) context.getAttribute("count");
        count--;
        context.setAttribute("count",count);


    }
}

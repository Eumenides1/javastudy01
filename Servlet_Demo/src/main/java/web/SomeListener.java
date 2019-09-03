package web;

import dao.UserDAO;
import entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * 监听servlet上下文的创建和销毁
 * @author Eumenides
 */
@WebListener
public class SomeListener implements ServletContextListener {
    /**
     * Servlet上下文被销毁之后会执行
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized()");
        //使用dao查询数据库，将用户信息绑定到Servlet上下文
        List<User> users = new UserDAO().findAll();
        sce.getServletContext().setAttribute("users",users);
    }

    /**
     * Servlet上下文创建之后会执行
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed()");
    }
}

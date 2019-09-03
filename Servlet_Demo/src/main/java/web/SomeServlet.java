package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Eumenides
 */
@WebServlet(value = "/some",initParams = {
        @WebInitParam(name="company",value = "北京达内科技")
})
public class SomeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 获得ServletContext
         *  注：
         *     通过继承自GenericServlet提供的
         *     getServletContext方法
         */
        ServletContext context =  getServletContext();
        context.setAttribute("username","Sally");


        String company = context.getInitParameter("company");
        System.out.println(company);

//        HttpSession session = request.getSession();
//        session.setAttribute("username","Peter");



    }
}

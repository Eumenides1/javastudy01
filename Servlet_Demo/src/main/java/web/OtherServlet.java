package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Eumenides
 */
@WebServlet("/other")
public class OtherServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletContext context = getServletContext();
//        String username = (String)context.getAttribute("username");
//        System.out.println(username);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println(username);
    }
}

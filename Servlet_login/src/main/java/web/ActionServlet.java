package web;

import dao.UserDAO;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Eumenides
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("actionServlet's service()");
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
        System.out.println("action:"+action);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        if("/list".equals(action)){
            /*
             * 进行session验证，只有登录过的用户才能使用该功能，查询用户列表
             */
            HttpSession session = request.getSession();
            Object obj = session.getAttribute("user");
            if(obj == null){
                //没有登录过，跳转到登录页面
                response.sendRedirect("login.jsp");
                //没登录，下面的逻辑不执行
                return;
            }
//            response.setContentType(
//                    "text/html;charset=utf-8");
//            PrintWriter out = response.getWriter();
            /*
             * 使用DAO查询数据库，将所有用户信息查询出来
             */
            UserDAO dao = new UserDAO();
            try{
                List<User> users = dao.findAll();
                //step1.绑定数据到request上面
                request.setAttribute("users",users);
                //step2.获得转发器
                RequestDispatcher rd = request.getRequestDispatcher("listUsers.jsp");
                //step3.转发
                rd.forward(request,response);


            }catch(Exception e){
                e.printStackTrace();
                out.println("系统繁忙，稍后重试");
            }

        }else if("/add".equals(action)){
//            response.setContentType(
//                    "text/html;charset=utf-8");
//            PrintWriter out =
//                    response.getWriter();

            /*
             * 读取用户信息
             */
            String username =
                    request.getParameter("uname");
            String pwd =
                    request.getParameter("pwd");
            String phone =
                    request.getParameter("phone");

            System.out.println("username:"
                    + username + " pwd:"
                    + pwd + " phone:" + phone);

            /*
             * 服务器端应该对用户提交的数据进行合法性检查，
             * 比如，检查用户名是否为空等，此处暂时不考虑。
             */

            /*
             * 使用DAO将用户信息插入到数据库
             */
            UserDAO dao = new UserDAO();

            User user = new User();
            user.setUsername(username);
            user.setPwd(pwd);
            user.setPhone(phone);
            try{
                dao.save(user);

                //重定向到用户列表
                response.sendRedirect("list.do");
                //System.out.println("重定向之后的代码");
            }catch(Exception e){
                e.printStackTrace();
                out.println("系统繁忙，稍后重试");
            }
        }else if("/del".equals(action)){
            String id =
                    request.getParameter("id");
            //调用DAO提供的方法，删除数据库中的对应的员工记录
            UserDAO dao = new UserDAO();
            try{
                dao.delete(Integer.parseInt(id));
                //重定向到用户列表
                response.sendRedirect("list.do");
            }catch(Exception e){
                e.printStackTrace();
                out.println("系统繁忙，稍后重试");
            }
        }else if("/login".equals(action)){
            //先比较验证码是否正确
            String number1 = request.getParameter("number");
            HttpSession session = request.getSession();
            String number2 = (String) session.getAttribute("number");

            if(!number1.equals(number2)){
                //验证码不正确,给用户相应的提示
                request.setAttribute("number_error","验证码不正确");
                request.getRequestDispatcher("login.jsp").forward(request,response);
                return;
            }

            //读取用户名和密码
            String username = request.getParameter("uname");
            String pwd = request.getParameter("pwd");

            //使用DAO查询数据库
            UserDAO dao = new UserDAO();
            try {
                User user = dao.find(username);
                if(user!=null && user.getPwd().equals(pwd)){
                    //登陆成功，绑定一些数据到session对象上
                    session.setAttribute("user",user);
                    //登录成功，跳转用户列表
                    response.sendRedirect("list.do");

                }else {
                    //登陆失败，提示用户
                    request.setAttribute("login_faild","用户名或密码错误");
                    request.getRequestDispatcher("login.jsp").forward(request,response);

                }
            }catch (Exception e){
                e.printStackTrace();
                out.println("系统繁忙，稍后重试");
            }
        }

    }
}

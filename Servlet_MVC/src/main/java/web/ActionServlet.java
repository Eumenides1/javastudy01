package web;

import service.BMIService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制器
 *      控制器主要负责两件事：
 *        1.依据请求路径调用对应的模型来处理
 *        2.依据模型返回的处理结果，调用对应的视图来呈现
 * @author Eumenides
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
        System.out.println("action:"+action);
        if("/toBMI".equals(action)){
            request.getRequestDispatcher("/WEB-INF/BMI_form.jsp").forward(request,response);
        }
        //1.依据请求路径调用对应的模型来处理
        if("/bmi".equals(action)){
            String height = request.getParameter("height");
            String weight = request.getParameter("weight");

            BMIService bmiService = new BMIService();
            String status = bmiService.bmi(Double.parseDouble(height),Double.parseDouble(weight));
            //2.依据模型返回的处理结果，调用对应的视图来呈现
            request.setAttribute("status",status);
            request.getRequestDispatcher("/WEB-INF/view2.jsp").forward(request,response);
        }

    }
}

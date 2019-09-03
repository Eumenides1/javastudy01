package web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Eumenides
 */
@WebFilter(filterName = "commentfilter2",urlPatterns = "/process",initParams = {@WebInitParam(name="maxcount",value="10") })
public class CommentFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        String content = request.getParameter("content");

        if(content.length()>10){
            out.println("输入字符不得超过十个");
        }else {
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}

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
@WebFilter(filterName = "commentFilter",urlPatterns = "/process",
        initParams = { @WebInitParam(name="illegal",value = "猫")})
public class CommentFilter implements Filter {

    private FilterConfig config;

    /**
     *容器启动之后，会立即创建过滤器实例
     * 注：
     *      只会创建一个
     */
    public CommentFilter() {
        System.out.println("CommentFilter's constructor");
    }

    /**
     *实例化之后，容器会立即调用init方法来完成初始化
     * 注：
     *      该方法只会执行一次
     * FilterConfig可以用来读取初始化参数
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;

        System.out.println("CommentFilter's init()");
    }

    /**
     * 容器调用doFilter来处理请求（类似于service方法）
     * FilterChain:如果调用了该对象的doFilter方法，则容器继续向后执行
     * 否则，中断请求，返回结果
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter begin...");

        /*
         * 使用子接口的请求响应对象，需要强制转换
         */
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String content = request.getParameter("content");
        //读取初始化参数，来获得敏感值
        String illegal = config.getInitParameter("illegal");
        if(content.indexOf(illegal)!= -1){
            //包含敏感字，则中断请求，返回结果
            out.println("评论包含敏感词汇");
        }else {
            //继续向后调用
            filterChain.doFilter(request,response);
        }
        System.out.println("doFilter end");
    }

    @Override
    public void destroy() {

    }
}

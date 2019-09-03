package cn.tedu.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object o) throws Exception {

        //日志
        System.out.println("loginInterceptor.preHandle");
        System.out.println(request);
        System.out.println(response);
        System.out.println(o);

        //获取HttpSession对象
        HttpSession session = request.getSession();
        //判断是否登录
        if(session.getAttribute("uid") == null){
            //确定重定向到的页面：主页
            String url = request.getContextPath()+"/main/index.do";
            //没有登录，则跳转(重定向)到主页
            response.sendRedirect(url);
            //拦截
            return false;
        }
        //放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o,
                                Exception e) throws Exception {

    }
}

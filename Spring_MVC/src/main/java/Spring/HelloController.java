package Spring;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eumenides
 */
@org.springframework.stereotype.Controller
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //创建返回值
        ModelAndView mav = new ModelAndView();
        //确定前端页面
        mav.setViewName("hello");
        //返回
        return mav;
    }
}

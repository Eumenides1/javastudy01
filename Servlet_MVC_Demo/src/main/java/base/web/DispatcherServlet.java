package base.web;

import base.common.BeansManger;
import base.common.HandlerMapping;
import base.common.URLHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


/**
 * @author Eumenides
 */
public class DispatcherServlet extends HttpServlet {
//    //保存配置文件中的bean值
//    private  List beans = new ArrayList();
    private BeansManger bm = new BeansManger();

    private HandlerMapping hm = new HandlerMapping();

    @Override
    public void init() throws ServletException {
        //读取配置文件的位置及文件名
        String configName = getServletConfig().getInitParameter("configLocation");
        System.out.println("configName:"+configName);
        try {
            //解析配置文件的工作交给了BeansManger
            bm.parse(configName);
            hm.process(bm.getBeans());

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读取请求资源路径
        request.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        System.out.println("uri:"+uri);
        //获得应用名
        String contextPath = request.getContextPath();
        System.out.println("contextPath:"+contextPath);
        //截取请求资源路径，应用名之后的那一部分
        String path = uri.substring(contextPath.length());
        System.out.println("path:"+path);

        //依据请求路径找到对应的模型来处理
        URLHandler urlHandler = hm.getURLHandler(path);
        System.out.println("urlHandler:"+urlHandler);
        //调用模型的方法
        Method method = urlHandler.getMh();
        Object obj = urlHandler.getObj();
        Object viewName;
        try {
            /*
             * 通过java反射，查看方法是否需要request和response
             * 如果需要，则将这两个对象作为参数传过去
             */
            //获得方法所带的参数的类型
            Class[] types = method.getParameterTypes();
            if (types.length>0) {
                Object[] args = new Object[types.length];
                //带参数
                for (int i = 0; i<types.length; i++) {
                    if(types[i] == HttpServletRequest.class){
                        args[i] = request;
                    }
                    if(types[i] == HttpServletResponse.class){
                        args[i] = response;
                    }
                }
                //执行带参的方法
                viewName = method.invoke(obj,args);
            }else{
                //方法不带参数
                //viewName：模型方法执行完毕之后的返回值
                viewName =  method.invoke(obj);
            }


            System.out.println("viewName:"+viewName);
            //调用processView来处理视图名（即跳转到某个页面）
            processView(viewName,request,response);


        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    private void processView(Object viewName,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        /*
         * 如果viewName是以"redirect:"开头的，则重定向，否则转发
         */
        if(viewName.toString().startsWith("redirect:")){
            //重定向
            //生成重定向地址
            String aimPath = request.getContextPath()+"/"+viewName.toString().substring("redirect:".length());
            response.sendRedirect(aimPath);
        }else{
            /*
             * 生成转发的目的地
             */
            String aimPath = "/WEB-INF/"+viewName.toString()+".jsp";
            System.out.println(aimPath);
            //开始转发
            request.getRequestDispatcher(aimPath).forward(request,response);
        }

    }
}

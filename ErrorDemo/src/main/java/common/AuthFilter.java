package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(value = "/*")
public class AuthFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// ��¼ҳ�棬ִ�е�¼���˳�ϵͳ����̬��Դ�������ܼ���Ƿ��¼
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		uri = uri.substring(contextPath.length());
		System.out.println("uri=" + uri);
		if (uri.equals("/") || uri.contains("login.jsp") || uri.contains("userServlet") || uri.endsWith(".js")
				|| uri.endsWith(".css") || uri.endsWith(".jpg") || uri.endsWith(".png")) {
			chain.doFilter(request, response);
		} else {
			Object userInfo = request.getSession().getAttribute("userInfo");
			if (userInfo == null) {
				// û�е�¼
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

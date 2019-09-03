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

@WebFilter(value = "/*")
public class LogFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("====LogFilter.destroy()��ִ����");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;

		String uri = request.getRequestURI();
		if (uri.contains("prdServlet")) {
			String remoteIp = req.getRemoteAddr();
			long start = System.currentTimeMillis();
			chain.doFilter(req, resp);
			long end = System.currentTimeMillis();
			System.out.println("�ͻ���IP��" + remoteIp + " �����ʱ:" + (end - start) + "ms.");
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("====LogFilter.init()��ִ����");
	}

}

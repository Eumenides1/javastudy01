package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns="/*")
public class CharEncodingFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("========CharEncodingFilter�������ˡ�������");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//Ԥ����
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		chain.doFilter(req, resp);
		//����
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("========CharEncodingFilter��ʵ�����ˡ�������");
	}

}

package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import vo.UserInfo;

@WebServlet(value = { "/userServlet", "/usrServlet" }, loadOnStartup = 1)
public class UserServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String flag = req.getParameter("flag");
		if ("logout".equals(flag)) {
			req.getSession().invalidate();
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String flag = req.getParameter("flag");
		if ("login".equals(flag)) {
			// ��ȡ����
			String account = super.parseParamValue(req, "account", String.class);
			String pwd = super.parseParamValue(req, "pwd", String.class);
			UserInfo userInfo = UserService.getInstance().findUserByAccount(account);
			if (userInfo == null) {
				req.setAttribute("msg", "�˺Ų�����!");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			} else {
				if (userInfo.getPwd().equals(pwd)) {
					req.getSession().setAttribute("userInfo", userInfo);
					resp.sendRedirect(req.getContextPath() + "/index.jsp");
				} else {
					req.setAttribute("msg", "���벻��ȷ!");
					req.getRequestDispatcher("/login.jsp").forward(req, resp);
				}
			}
		}
	}
}

package Servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class BaseServlet extends HttpServlet {

	public <T> T parseParamValue(HttpServletRequest req, String paraName, Class<T> clz) {

		// ������еĿؼ�û�������κ����ݣ������˻�ȡ���Ĳ���ֵΪ�մ�(����Ϊ0���ַ���)
		// ����û��ָ���Ĳ���ʱ���õ���ֵΪnull
		String value = req.getParameter(paraName);
		if (value == null || value.length() == 0) {
			return null;
		}
		T result = null;
		if (clz == String.class || Number.class.isAssignableFrom(clz)) {
			try {
				result = clz.getDeclaredConstructor(String.class).newInstance(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}

package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductService;
import service.ProductTypeService;
import vo.ProductInfo;
import vo.ProductTypeInfo;

@WebServlet(urlPatterns = "/prdServlet", loadOnStartup = 2)
public class ProductServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String flag = req.getParameter("flag");
		if ("list".equals(flag)) {
			// �����������ȡ��Ʒ�б�����jspҳ����ʾ
			List<ProductInfo> list = ProductService.getInstance().findAllProducts();
			req.setAttribute("prd_list", list);
			req.getRequestDispatcher("/prd/prd_list.jsp").forward(req, resp);
		} else if ("preAdd".equals(flag)) {
			// ׼��¼����Ʒ����ȡ��Ʒ����б�
			List<ProductTypeInfo> typeList = ProductTypeService.getInstance().findAllTypes();
			req.setAttribute("type_list", typeList);
			req.getRequestDispatcher("/prd/prd_add.jsp").forward(req, resp);
		} else if ("preEdit".equals(flag)) {
			// �����ύ����Ʒ��Ŵ����ݿ��ж�ȡ��Ʒ��Ϣ��Ȼ��չʾ�༭ҳ��
			Integer prdId = super.parseParamValue(req, "prdId", Integer.class);
			if (prdId != null) {
				ProductInfo prdInfo = ProductService.getInstance().findById(prdId);
				req.setAttribute("prdInfo", prdInfo);
				// ��Ʒ����б�
				req.setAttribute("typeList", ProductTypeService.getInstance().findAllTypes());
				req.getRequestDispatcher("/prd/prd_edit.jsp").forward(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String flag = req.getParameter("flag");
		if ("add".equals(flag)) {
			// ��ȡ�ύ�����Ĳ���ֵ
			Integer price = parseParamValue(req, "price", Integer.class);
			String prdName = parseParamValue(req, "prdName", String.class);
			Integer typeId = parseParamValue(req, "typeId", Integer.class);
			String desc = parseParamValue(req, "desc", String.class);

			// ������ֵ��װ��ProductInfo������
			ProductInfo info = new ProductInfo();
			info.setPrice(price);
			info.setPrdName(prdName);
			if (typeId != null && typeId != 0)
				info.setTypeId(typeId);
			info.setDesc(desc);

			// ����
			boolean result = ProductService.getInstance().save(info);
			resp.sendRedirect(req.getContextPath() + "/prdServlet?flag=preAdd&msg=" + (result ? 1 : -1));
		} else if ("edit".equals(flag)) {
			// ��ȡ�ύ�����Ĳ���ֵ
			Integer prdId = super.parseParamValue(req, "prdId", Integer.class);
			Integer price = parseParamValue(req, "price", Integer.class);
			String prdName = parseParamValue(req, "prdName", String.class);
			Integer typeId = parseParamValue(req, "typeId", Integer.class);
			String desc = parseParamValue(req, "desc", String.class);

			// ������ֵ��װ��ProductInfo������
			ProductInfo info = new ProductInfo();
			info.setPrice(price);
			info.setPrdName(prdName);
			if (typeId != null && typeId != 0)
				info.setTypeId(typeId);
			info.setDesc(desc);
			info.setPrdId(prdId);
			// �༭
			boolean result = ProductService.getInstance().edit(info);
			resp.sendRedirect(req.getContextPath() + "/prdServlet?flag=list&msg=" + (result ? 2 : -2));
		}
	}
}

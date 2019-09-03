package service;

import java.util.List;

import dao.ProductTypeDao;
import vo.ProductTypeInfo;
import vo.ProductTypeInfo;

public class ProductTypeService {
	private static ProductTypeService instance;

	public synchronized static ProductTypeService getInstance() {
		if (instance == null) {
			instance = new ProductTypeService();
		}
		return instance;
	}

	private ProductTypeService() {
	}

	public List<ProductTypeInfo> findAllTypes() {
		return ProductTypeDao.getInstance().findAllTypes();
	}
}

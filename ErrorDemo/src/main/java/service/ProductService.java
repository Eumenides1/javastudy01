package service;

import java.util.List;

import dao.ProductDao;
import vo.ProductInfo;

public class ProductService {
	private static ProductService instance;

	public synchronized static ProductService getInstance() {
		if (instance == null) {
			instance = new ProductService();
		}
		return instance;
	}

	private ProductService() {
	}

	public List<ProductInfo> findAllProducts() {
		return ProductDao.getInstance().findAllProducts();
	}

	public boolean save(ProductInfo info) {
		int count = ProductDao.getInstance().save(info);
		return count > 0;
	}

	public ProductInfo findById(Integer prdId) {
		return ProductDao.getInstance().findById(prdId);
	}

	public boolean edit(ProductInfo info) {
		int count = ProductDao.getInstance().edit(info);
		return count > 0;
	}
}

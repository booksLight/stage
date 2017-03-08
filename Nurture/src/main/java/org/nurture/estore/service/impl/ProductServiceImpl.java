package org.nurture.estore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.nurture.estore.dao.ProductDao;
import org.nurture.estore.model.Product;
import org.nurture.estore.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }

	public List<Product> getProducts(Integer offset, Integer maxResults) {
		return productDao.getProducts(offset, maxResults);
	}

	public Long countProducts() {
		return productDao.countProducts();
	}
}

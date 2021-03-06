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


    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    public Integer addProduct(Product product) {
        return productDao.addProduct(product);
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

	public Long countProducts(String lookUp) {
		return productDao.countProducts(lookUp);
	}

	public List<Product> getProductsPage(Integer offset, Integer maxResults, String lookUp) {
		return productDao.getProductsPage(offset, maxResults, lookUp);
	}
}

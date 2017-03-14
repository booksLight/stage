package org.nurture.estore.service;

import org.nurture.estore.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    Integer addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

	List<Product> getProducts(Integer offset, Integer maxResults);
	public Long countProducts();

}

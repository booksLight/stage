package org.brand.self.dao;

import java.util.List;

import org.brand.self.model.Product;

public interface ProductDao {

    List<Product> getProductList();

    Product getProductById (int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}

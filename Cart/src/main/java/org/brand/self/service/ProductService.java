package org.brand.self.service;


import java.util.List;

import org.brand.self.model.Product;

public interface ProductService {

    List<Product> getProductList();

    Product getProductById (int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

}

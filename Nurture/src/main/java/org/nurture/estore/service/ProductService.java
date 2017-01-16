package org.nurture.estore.service;

import org.nurture.estore.model.Product;

import java.util.List;

/**
 * Created by Andrew on 18.04.2016.
 */
public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

}

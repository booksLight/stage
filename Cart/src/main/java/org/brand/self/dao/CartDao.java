package org.brand.self.dao;


import java.io.IOException;

import org.brand.self.model.Cart;

public interface CartDao {

    Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);

}


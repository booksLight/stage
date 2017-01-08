package org.brand.self.service;

import org.brand.self.model.Cart;

public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}

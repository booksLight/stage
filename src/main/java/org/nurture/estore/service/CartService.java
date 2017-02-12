package org.nurture.estore.service;

import org.nurture.estore.model.Cart;

public interface CartService {
    Cart getCartById(int id);

    void update(Cart cart);
}

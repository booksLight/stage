package org.nurture.estore.service;

import org.nurture.estore.model.Cart;

/**
 * Created by Andrew on 07.05.2016.
 */
public interface CartService {
    Cart getCartById(int id);

    void update(Cart cart);
}

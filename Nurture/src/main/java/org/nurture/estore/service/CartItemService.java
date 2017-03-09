package org.nurture.estore.service;

import org.nurture.estore.model.Cart;
import org.nurture.estore.model.CartItem;
import org.nurture.estore.model.CustomerOrder;

public interface CartItemService {
    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);
    
    void removeCartItemById(Integer cartItemId);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
}

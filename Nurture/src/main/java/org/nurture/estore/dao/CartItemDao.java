package org.nurture.estore.dao;

import org.nurture.estore.model.Cart;
import org.nurture.estore.model.CartItem;

public interface CartItemDao {
    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeCartItemById(Integer cartItemId);
    
    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
}

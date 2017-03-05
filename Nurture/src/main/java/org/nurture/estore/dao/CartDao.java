package org.nurture.estore.dao;

import org.springframework.stereotype.Repository;
import org.nurture.estore.model.Cart;

import java.io.IOException;

@Repository
public interface CartDao {

    Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);

	void updateGrandTotal(Cart cart);
}

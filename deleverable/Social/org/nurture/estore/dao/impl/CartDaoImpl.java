package org.nurture.estore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.nurture.estore.dao.CartDao;
import org.nurture.estore.model.Cart;
import org.nurture.estore.service.CustomerOrderService;

import java.io.IOException;

/**
 * Created by Andrew on 07.05.2016.
 */
@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CustomerOrderService customerOrderService;

    public Cart getCartById(int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    public Cart validate(int cartId) throws IOException {
    	System.out.println("\n ******\t this is requestParameters.cartId = "+cartId);
       /* Cart cart = getCartById(cartId);
        if (cart == null || cart.getCartItems().size() == 0) {
              throw new IOException(cartId + "");
        }

        update(cart);
        return cart;*/
    	
    	return null;
    }

    public void update(Cart cart) {
        int cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }
}

package org.nurture.estore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.nurture.estore.dao.CartDao;
import org.nurture.estore.model.Cart;
import org.nurture.estore.service.CustomerOrderService;
import org.nurture.estore.service.impl.MailImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Andrew on 07.05.2016.
 */
@Repository
@Transactional
public class CartDaoImpl implements CartDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class);
	
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CustomerOrderService customerOrderService;

    public Cart getCartById(int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    public Cart validate(int cartId) throws IOException {
    	logger.debug("\n ******\t this is requestParameters.cartId = "+cartId);
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

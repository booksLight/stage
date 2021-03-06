package org.nurture.estore.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.nurture.estore.dao.CartItemDao;
import org.nurture.estore.model.Cart;
import org.nurture.estore.model.CartItem;
import org.nurture.estore.util.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Andrew on 07.05.2016.
 */
@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{

	private static final Logger logger = LoggerFactory.getLogger(CartItemDaoImpl.class);
	
    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    public void removeAllCartItems(Cart cart) {
    	if(cart.getCartItems() != null){
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            removeCartItem(item);
        }
    	}
    	logger.info("\t Cart has been empity successfully.. !");
    }

    public CartItem getCartItemByProductId(int productId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where productId = ?");
        query.setInteger(0, productId);
        session.flush();

        return (CartItem) query.uniqueResult();
    }

	public void removeCartItemById(Integer cartItemId) {
				
		 logger.debug("\n\n Removing cartiitemid ="+cartItemId);
		 Session session = sessionFactory.getCurrentSession();
		 
		 /*	 CartItem myObject = (CartItem) session.load(CartItem.class,cartItemId);
		if(myObject != null){
		 session.delete(myObject);
		}*/
		 
		 Query query = session.createQuery("delete CartItem where cartItemId = :cartItemId");
		 query.setParameter("cartItemId", cartItemId);
		  
		 int result = query.executeUpdate();
		  
		 if (result > 0) {
			 logger.debug("\n\n"+cartItemId +" deleted successfully.");
		 }
		
	}

}

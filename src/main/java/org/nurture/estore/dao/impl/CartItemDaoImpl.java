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

import java.util.List;

/**
 * Created by Andrew on 07.05.2016.
 */
@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{

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
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            removeCartItem(item);
        }
    }

    public CartItem getCartItemByProductId(int productId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where productId = ?");
        query.setInteger(0, productId);
        session.flush();

        return (CartItem) query.uniqueResult();
    }

	public void removeCartItemById(Integer cartItemId) {
		Session session ;
		CartItem myObject ;
		
		 System.out.println("\n\n Removing cartiitemid ="+cartItemId);
		 session = sessionFactory.getCurrentSession();
		 myObject = (CartItem) session.load(CartItem.class,cartItemId);
		 session.delete(myObject);
		 session.flush();

	}

}

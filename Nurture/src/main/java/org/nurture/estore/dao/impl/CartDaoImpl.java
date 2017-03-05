package org.nurture.estore.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.nurture.estore.dao.CartDao;
import org.nurture.estore.model.Cart;
import org.nurture.estore.service.CustomerOrderService;
import org.nurture.estore.service.impl.CartServiceImpl;
import org.nurture.estore.service.impl.MailImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Rakesh Sharma on 22.02.2017.
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

	public void updateGrandTotal(Cart cartParam) {
		daoLog(this.getClass(), "updateGrandTotal", "START");
		 Session session = sessionFactory.getCurrentSession();
		 
		String hqlUpdateQuery= "update cart set grandTotal=:cartTotal where cartId=:newCartId";
			 Query query1 = session.createSQLQuery(hqlUpdateQuery);
			 		query1.setParameter("cartTotal", cartParam.getGrandTotal());
			 		query1.setParameter("newCartId",cartParam.getCartId());
		int rowCount = query1.executeUpdate();
		logger.debug("Grand Total updated.... Cart Rows affected: " + rowCount);
		daoLog(this.getClass(), "updateGrandTotal", "END");
	}
	
	
	
	 private void daoLog(Class<? extends CartDaoImpl> paramCclass, String paramMethod, String paramMsg) {
			logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
		}
}

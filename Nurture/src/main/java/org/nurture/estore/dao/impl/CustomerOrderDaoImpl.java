package org.nurture.estore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.nurture.estore.controller.OrderController;
import org.nurture.estore.dao.CustomerOrderDao;
import org.nurture.estore.model.CustomerOrder;
import org.nurture.estore.model.OrderBook;
import org.nurture.estore.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Andrew on 07.05.2016.
 */

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	private static final Logger logger = LoggerFactory.getLogger(CustomerOrderDaoImpl.class);
	
    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomerOrder(CustomerOrder customerOrder) {
    	daoLog(this.getClass(), "addCustomerOrder", "START ");
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
        daoLog(this.getClass(), "addCustomerOrder", "END ");
    }

	public void saveOrUpdateOrderBook(OrderBook orderBookParam) {
		  daoLog(this.getClass(), "saveOrUpdateOrderBook", "START ");
		 	Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(orderBookParam);
	        session.flush();
	     daoLog(this.getClass(), "saveOrUpdateOrderBook", "END ");
	}
	
	public CustomerOrder getCustomerOrderById(Integer customerOrderId) {
		  daoLog(this.getClass(), "getCustomerOrderById", "START ");
		 	Session session = sessionFactory.getCurrentSession();
		 	return	session.get(CustomerOrder.class, customerOrderId);
	}
	
	
	 private void daoLog(Class<? extends CustomerOrderDaoImpl> paramCclass, String paramMethod, String paramMsg) {
			logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
		}

	public List<OrderBook> getOrderedBooksByOrderId(Integer customerOrderId) {
		 daoLog(this.getClass(), "getOrderedBooksByOrderId", "START ");
		 Session session = sessionFactory.getCurrentSession();
		
	    try{
	    	 Query query = session.createQuery("from OrderBook where orderId = ?");
	  
	    	query.setLong(0, customerOrderId);
	    
	        if(query.list() != null){
	        	return (List<OrderBook>) query.list() ;
	        }
	        daoLog(this.getClass(), "getOrderedBooksByOrderId", "Found Ordered Book");
	        }catch(Exception e){
	        	daoLog(this.getClass(), "getOrderedBooksByOrderId", "ERROR ="+e.getMessage());
	        }
	       
	        daoLog(this.getClass(), "getOrderedBooksByOrderId", "End");
		return null;
	}

	public List<CustomerOrder> getCustomerOrdersByCartId(Integer cartId) {
		 daoLog(this.getClass(), "getCustomerOrdersByCartId", "START ");
		 Session session = sessionFactory.getCurrentSession();
		
	    try{
	    	 Query query = session.createQuery("from CustomerOrder where cartId = ?");
	  
	    	query.setLong(0, cartId);
	    
	        if(query.list() != null){
	        	return (List<CustomerOrder>) query.list() ;
	        }
	        daoLog(this.getClass(), "getCustomerOrdersByCartId", "Found Ordered Book");
	        }catch(Exception e){
	        	daoLog(this.getClass(), "getCustomerOrdersByCartId", "ERROR ="+e.getMessage());
	        }
	       
	        daoLog(this.getClass(), "getCustomerOrdersByCartId", "End");
		return null;
	}

	
}

package org.nurture.estore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.nurture.estore.controller.OrderController;
import org.nurture.estore.dao.CustomerOrderDao;
import org.nurture.estore.model.CustomerOrder;
import org.nurture.estore.model.OrderBook;
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
	
	
	
	
	 private void daoLog(Class<? extends CustomerOrderDaoImpl> paramCclass, String paramMethod, String paramMsg) {
			logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
		}
}

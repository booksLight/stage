package org.nurture.estore.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nurture.estore.dao.AdminDao;
import org.nurture.estore.vo.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

private static final Logger logger = LoggerFactory.getLogger(AdminDaoImpl.class);
	
    @Autowired
    private SessionFactory sessionFactory;
    
	public List<OrderMapper> getOrdersRowMapper() {
		daoAdminLog(this.getClass(), "getOrdersRowMapper", "START ");
		 List<OrderMapper> oms = null;
		 OrderMapper om;
		String ORDER_ROW_MAPPER_HQL = "SELECT c.customerName,  p.productName, sum(ob.quantity), sum(ob.totalPrice), co.stamped, co.customerOrderId, co.status, co.cartId, co.isConfirmed, co.isShipped"
				+ "	FROM Customer c "
				+ " JOIN CustomerOrder co ON c.cartId = co.cartId AND c.customerId = co.customerId "
				+ " JOIN OrderBook ob ON c.cartId = ob.cartId AND ob.cartId = c.cartId AND ob.orderId = co.customerOrderId"
				+ " JOIN Product p ON p.productId = ob.productId "
				+ " GROUP BY co.customerOrderId";
		
		
        Session session = sessionFactory.getCurrentSession();
       try{
        Query query = session.createNativeQuery(ORDER_ROW_MAPPER_HQL);
        
        List<Object[]> list = query.list();
        oms = new ArrayList<OrderMapper>();
       int counter=1;
        for(Object[] arr : list){
        	om = new OrderMapper();
        	om.setId(counter);
        	om.setCustomerName(arr[0].toString());
        	om.setProductName(arr[1].toString());
        	om.setOrderedQty(((BigDecimal)arr[2]).intValue());
        	om.setOrderedAmt((Double)arr[3]);
			om.setStamped((Timestamp)arr[4]);
			om.setCustomerOrderId((Integer)arr[5]);
			om.setStatus(arr[6].toString());
			om.setConfirmed((arr[8].toString() != null ? (arr[8].toString() == "true" ? true : false) : false));
			om.setShipped((arr[9].toString() != null ? (arr[9].toString() == "true" ? true : false) : false));
			oms.add(om);
			 System.out.println("\n\t Result =  :"+om.toString());
			 counter++;
		}
        
       }catch(Exception e){
    	   System.out.println("\n\t ORDER_ROW_MAPPER_HQL : Error ::"+e.getMessage());
       }
        daoAdminLog(this.getClass(), "getOrdersRowMapper", "END ");
		return oms;
	}

	
	
	
	
	 private void daoAdminLog(Class<? extends AdminDaoImpl> paramCclass, String paramMethod, String paramMsg) {
			logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
		}
}

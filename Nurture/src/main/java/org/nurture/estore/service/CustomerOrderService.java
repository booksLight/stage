package org.nurture.estore.service;

import java.util.List;

import org.nurture.estore.model.CustomerOrder;
import org.nurture.estore.model.OrderBook;


public interface CustomerOrderService {
    void addCustomerOrder(CustomerOrder customerOrder);
    void saveOrUpdateOrderBook(OrderBook orderBookParam);
    

    double getCustomerOrderGrandTotal(int cartId);

    CustomerOrder getCustomerOrderById(Integer customerOrderId);
    
	List<OrderBook> getOrderedBooksByOrderId(Integer customerOrderId);

	List<CustomerOrder> getCustomerOrdersByCartId(Integer cartId);
	

}

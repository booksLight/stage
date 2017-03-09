package org.nurture.estore.dao;

import java.util.List;

import org.nurture.estore.model.CustomerOrder;
import org.nurture.estore.model.OrderBook;

public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);
    void saveOrUpdateOrderBook(OrderBook orderBookParam);
	CustomerOrder getCustomerOrderById(Integer customerOrderId);
	List<OrderBook> getOrderedBooksByOrderId(Integer customerOrderId);
	List<CustomerOrder> getCustomerOrdersByCartId(Integer cartId);
}

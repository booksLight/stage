package org.nurture.estore.service;

import org.nurture.estore.model.CustomerOrder;
import org.nurture.estore.model.OrderBook;


public interface CustomerOrderService {
    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
    
    void saveOrUpdateOrderBook(OrderBook orderBookParam);

}

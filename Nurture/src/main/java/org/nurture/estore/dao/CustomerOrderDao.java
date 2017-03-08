package org.nurture.estore.dao;

import org.nurture.estore.model.CustomerOrder;
import org.nurture.estore.model.OrderBook;

public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);
    void saveOrUpdateOrderBook(OrderBook orderBookParam);
}

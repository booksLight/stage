package org.nurture.estore.service;

import org.nurture.estore.model.CustomerOrder;


public interface CustomerOrderService {
    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);


}

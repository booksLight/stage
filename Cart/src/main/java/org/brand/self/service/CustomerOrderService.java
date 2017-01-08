package org.brand.self.service;

import org.brand.self.model.CustomerOrder;

public interface CustomerOrderService {

    public void addCustomerOrder(CustomerOrder customerOrder);

    public double getCustomerOrderGrandTotal(int cartId);
}

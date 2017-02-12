package org.nurture.estore.service;

import org.nurture.estore.model.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);

	Customer getCustomerByUserID(Integer userId);
}

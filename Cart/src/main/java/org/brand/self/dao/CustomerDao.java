package org.brand.self.dao;

import java.util.List;

import org.brand.self.model.Customer;

public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
}

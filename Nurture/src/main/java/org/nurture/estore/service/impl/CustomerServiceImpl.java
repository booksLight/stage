package org.nurture.estore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.nurture.estore.dao.CustomerDao;
import org.nurture.estore.model.Customer;
import org.nurture.estore.model.ShippingAddress;
import org.nurture.estore.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(Integer id) {
        return customerDao.getCustomerById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername(String username) {
        return customerDao.getCustomerByUsername(username);
    }

	public Customer getCustomerByUserID(Integer userId) {
		 return customerDao.getCustomerByUserID(userId);
	}

	public boolean updateShippingAddress(Customer customerParam) {
		return customerDao.updateShippingAddress(customerParam);
	}
}

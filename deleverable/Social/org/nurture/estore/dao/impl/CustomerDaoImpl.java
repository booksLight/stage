package org.nurture.estore.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.nurture.estore.dao.CustomerDao;
import org.nurture.estore.model.Authorities;
import org.nurture.estore.model.Cart;
import org.nurture.estore.model.Customer;
import org.nurture.estore.model.ShippingAddress;
import org.nurture.estore.model.User;

import javax.swing.text.DefaultEditorKit;
import java.util.List;

/**
 * Created by Rakesh Sharma on 22.02.2017.
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

       /* User newUser = new User();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());*/

        Authorities newAuthorities = new Authorities();
        newAuthorities.setUsername(customer.getCustomerName());
        newAuthorities.setAuthority("ROLE_USER");
       // session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthorities);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public Customer getCustomerById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, id);
    }

    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        return customerList;
    }

    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username = ?");
        query.setString(0, username);

        return (Customer) query.uniqueResult();
    }

	public Customer getCustomerByUserID(Integer userId) {
		System.out.println("\n\n CustomerDaoImpl --> getCustomerByUserID() "+userId);
		 Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("from Customer where userId = ?");
	        query.setInteger(0, userId);
	        	 return (Customer) query.uniqueResult();
	     
	}

	public boolean updateShippingAddress(Customer customerParam) {
			System.out.println("\n\n CustomerDaoImpl --> updateShippingAddress() : START"+customerParam.getShippingAddress().toString());
			boolean state = false;
		 if(customerParam != null && customerParam.getShippingAddress() != null){
			 ShippingAddress shipAdd =  customerParam.getShippingAddress();
			 Session session = sessionFactory.getCurrentSession();
			// session.saveOrUpdate(customerParam.getShippingAddress());
			
			 String hqlUpdateQuery= "update shippingaddress set streetName=:newStreet, apartmentNumber=:newapArtmentNumber, city=:newCity, state=:newstate, country=:newCountry, zipCode=:newZipCode where shippingAddressId=:shippAddressId";
			 
			 Query query1 = session.createSQLQuery(hqlUpdateQuery);
			 		query1.setParameter("newStreet",customerParam.getShippingAddress().getStreetName().toString());
		        	query1.setParameter("newapArtmentNumber",customerParam.getShippingAddress().getApartmentNumber().toString());
		        	query1.setParameter("newCity",customerParam.getShippingAddress().getCity().toString());
		        	query1.setParameter("newstate",customerParam.getShippingAddress().getState().toString());
		        	query1.setParameter("newCountry",customerParam.getShippingAddress().getCountry().toString());
		        	query1.setParameter("newZipCode",customerParam.getShippingAddress().getZipCode());
		        	query1.setParameter("shippAddressId",customerParam.getShippingAddress().getShippingAddressId());
		 
		        int rowCount = query1.executeUpdate();
		       
		        System.out.println("Rows affected: " + rowCount);
			 state = rowCount >0 ? true:false;
				System.out.println("\n\n CustomerDaoImpl --> updateShippingAddress() : SUCCESS *****");
		 }
			System.out.println("\n\n CustomerDaoImpl --> updateShippingAddress() : END");
			
		return state;
	}
	
	
}

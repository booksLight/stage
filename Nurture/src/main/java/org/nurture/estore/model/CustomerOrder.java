package org.nurture.estore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class CustomerOrder implements Serializable{

    private static final long serialVersionUID = -326682882158781273L;

    @Id
    @GeneratedValue
    private int customerOrderId;
    @Column
    private boolean isConfirmed;
    @Column
    private boolean isShipped;
    @Column
    private String status;
    @Column
    private Timestamp stamped;
    @OneToOne
    @JoinColumn(name="cartId")
    private Cart cart;
    @OneToOne
    @JoinColumn(name="customerId")
    private Customer customer;
    @OneToOne
    @JoinColumn(name="billingAddressId")
    private BillingAddress billingAddress;
    @OneToOne
    @JoinColumn(name="shippingAddressId")
    private ShippingAddress shippingAddress;
    
    public CustomerOrder() {}

	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public boolean isShipped() {
		return isShipped;
	}

	public void setShipped(boolean isShipped) {
		this.isShipped = isShipped;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getStamped() {
		return stamped;
	}

	public void setStamped(Timestamp stamped) {
		this.stamped = stamped;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
    
    
}


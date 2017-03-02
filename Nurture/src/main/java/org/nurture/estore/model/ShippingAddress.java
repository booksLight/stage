package org.nurture.estore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table
public class ShippingAddress implements Serializable{

    private static final long serialVersionUID = -6931381448961023962L;

    @Id
    @GeneratedValue
    private int shippingAddressId;
    @Column private String streetName;
    @Column private String apartmentNumber;
    @Column private String city;
    @Column private String state;
    @Column private String country;
    @Column private String zipCode;

    @OneToOne
    private Customer customer;

    public int getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(int shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

	@Override
	public String toString() {
		return "ShippingAddress [shippingAddressId=" + shippingAddressId + ", streetName=" + streetName
				+ ", apartmentNumber=" + apartmentNumber + ", city=" + city + ", state=" + state + ", country="
				+ country + ", zipCode=" + zipCode + ", customer=" + customer + "]";
	}

  
}

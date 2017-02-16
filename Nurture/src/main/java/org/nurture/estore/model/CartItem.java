package org.nurture.estore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CartItem implements Serializable{

    private static final long serialVersionUID = -2315417995661870272L;

    @Id
    @GeneratedValue
    private Integer cartItemId;

    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name= "productId")
    private Product product;

    private Integer quantity;
    private Double totalPrice;

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", cart=" + cart + ", product=" + product + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + "]";
	}
    
    
}

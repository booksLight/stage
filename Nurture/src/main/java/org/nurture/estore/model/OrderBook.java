package org.nurture.estore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderBook {
	
	@Id
	@GeneratedValue
	private Integer orderBookId;
	
	@Column private Integer orderId;
	
	@Column private Integer cartId;
	
	@Column private Integer cartItemId;
	
	@Column private Integer productId;
	
	@Column private Integer quantity;
	
	@Column private Double totalPrice;

	public Integer geDoubletOrderBookId() {
		return orderBookId;
	}

	public void setOrderBookId(Integer orderBookId) {
		this.orderBookId = orderBookId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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
	

}

package org.nurture.estore.vo;

import java.sql.Timestamp;

public class OrderMapper {

	private Integer orderMapperId;
	private Integer orderId;
	private Integer customerId;
	private String customerName;
	private Integer productId;
	private String productName;
	private Integer orderedQty;
	private double orderedAmt;
	private Timestamp stamped;
	private Integer customerOrderId;
	private String status;
	private boolean isConfirmed;
	private boolean isShipped;
	
	public OrderMapper() {
	}

	public OrderMapper(Integer orderMapperId, Integer orderId, Integer customerId, String customerName,
			Integer productId, String productName, Integer orderedQty, double orderedAmt, Timestamp stamped,
			Integer customerOrderId, String status, boolean isConfirmed, boolean isShipped) {
		this.orderMapperId = orderMapperId;
		this.orderId = orderId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.productId = productId;
		this.productName = productName;
		this.orderedQty = orderedQty;
		this.orderedAmt = orderedAmt;
		this.stamped = stamped;
		this.customerOrderId = customerOrderId;
		this.status = status;
		this.isConfirmed = isConfirmed;
		this.isShipped = isShipped;
	}

	public Integer getOrderMapperId() {
		return orderMapperId;
	}

	public void setOrderMapperId(Integer orderMapperId) {
		this.orderMapperId = orderMapperId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getOrderedQty() {
		return orderedQty;
	}

	public void setOrderedQty(Integer orderedQty) {
		this.orderedQty = orderedQty;
	}

	public double getOrderedAmt() {
		return orderedAmt;
	}

	public void setOrderedAmt(double orderedAmt) {
		this.orderedAmt = orderedAmt;
	}

	public Timestamp getStamped() {
		return stamped;
	}

	public void setStamped(Timestamp stamped) {
		this.stamped = stamped;
	}

	public Integer getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(Integer customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "OrderMapper [orderMapperId=" + orderMapperId + ", orderId=" + orderId + ", customerId=" + customerId
				+ ", customerName=" + customerName + ", productId=" + productId + ", productName=" + productName
				+ ", orderedQty=" + orderedQty + ", orderedAmt=" + orderedAmt + ", stamped=" + stamped
				+ ", customerOrderId=" + customerOrderId + ", status=" + status + ", isConfirmed=" + isConfirmed
				+ ", isShipped=" + isShipped + "]";
	}

	
	
}

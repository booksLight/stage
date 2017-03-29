package org.nurture.estore.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OrderMapper {
	private int id;
	/*private Integer orderMapperId;
	private Integer orderId;
	private Integer customerId;*/
	private String customerName;
	//private Integer productId;
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
	
	
	@Override
	public String toString() {
		return "OrderMapper [id=" + id + ", customerName=" + customerName + ", productName=" + productName
				+ ", orderedQty=" + orderedQty + ", orderedAmt=" + orderedAmt + ", stamped=" + stamped
				+ ", customerOrderId=" + customerOrderId + ", status=" + status + ", isConfirmed=" + isConfirmed
				+ ", isShipped=" + isShipped + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

		
}

package org.swift.order;

public class Order {
	private String orderId = "";
	private String orderDate = "";
	private String productId = "";
	private String paymentStatus = "";
	private String orderOwner = "";

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getOrderOwner() {
		return orderOwner;
	}

	public void setOrderOwner(String orderOwner) {
		this.orderOwner = orderOwner;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", productId=" + productId
				+ ", paymentStatus=" + paymentStatus + ", orderOwner=" + orderOwner + "]";
	}

}

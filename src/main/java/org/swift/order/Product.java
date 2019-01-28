package org.swift.order;

public class Product {

	private String productId = "";
	private String productCategory = "";
	private String productName = "";
	private String productOwner = "";

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductOwner() {
		return productOwner;
	}

	public void setProductOwner(String productOwner) {
		this.productOwner = productOwner;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productCategory=" + productCategory + ", productName="
				+ productName + ", productOwner=" + productOwner + "]";
	}

}
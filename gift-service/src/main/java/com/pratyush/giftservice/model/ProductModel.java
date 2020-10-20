package com.pratyush.giftservice.model;

public class ProductModel {
	private int productId;
    private int productQuantity;
    private String productDescription;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public ProductModel(int productId, int productQuantity, String productDescription) {
		super();
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.productDescription = productDescription;
	}
	public ProductModel() {
		super();
	}
	
    
}

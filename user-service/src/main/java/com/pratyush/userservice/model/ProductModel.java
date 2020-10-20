package com.pratyush.userservice.model;

public class ProductModel {
	private int productId;
	private double productPrice;
	private String productDescription;
	private int productQuantity;
	private ModelModel productModel;
	

	public ProductModel() {
		super();
		// constructor
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public ModelModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ModelModel productModel) {
		this.productModel = productModel;
	}
}


package com.pratyush.giftservice.entity;

import java.util.List;

import com.pratyush.giftservice.model.ProductModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "redeem_history")
public class RedeemProducts {
	@Id
	private String redeemCode;
	private String userId;
	private List<ProductModel> products;
	
	public RedeemProducts(String redeemCode, String userId, List<ProductModel> products) {
		super();
		this.redeemCode = redeemCode;
		this.userId = userId;
		this.products = products;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	

	public String getRedeemCode() {
		return redeemCode;
	}

	public void setRedeemCode(String redeemCode) {
		this.redeemCode = redeemCode;
	}

	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	public RedeemProducts(String redeemCode, List<ProductModel> products) {
		super();
		this.redeemCode = redeemCode;
		this.products = products;
	}

	public RedeemProducts() {
		super();
	}
}

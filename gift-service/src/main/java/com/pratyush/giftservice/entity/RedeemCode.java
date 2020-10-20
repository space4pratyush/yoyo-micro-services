package com.pratyush.giftservice.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "redeem")
public class RedeemCode {
	@Id
	private String redeemCode;

	public String getRedeemCode() {
		return redeemCode;
	}

	public void setRedeemCode(String redeemCode) {
		this.redeemCode = redeemCode;
	}

	public RedeemCode(String redeemCode) {
		super();
		this.redeemCode = redeemCode;
	}

	public RedeemCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RedeemCode [redeemCode=" + redeemCode + "]";
	}

}

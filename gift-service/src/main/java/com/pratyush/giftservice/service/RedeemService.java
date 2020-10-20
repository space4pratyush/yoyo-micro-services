package com.pratyush.giftservice.service;

import com.pratyush.giftservice.entity.RedeemCode;
import com.pratyush.giftservice.entity.RedeemProducts;

import java.util.List;

public interface RedeemService {

	public RedeemCode generateRedeemCode(String userId, int cartId);

	public boolean validateRedeemCode(String redeemID);

	public RedeemProducts redeemProducts(RedeemProducts redeemProducts);




}

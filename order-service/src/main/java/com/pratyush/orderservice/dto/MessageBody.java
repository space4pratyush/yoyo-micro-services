package com.pratyush.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageBody {
	private String redeemCode;

	private String endpoint;

	@Override
	public String toString() {
		return "You have recieved a few gifts, kindly redeem it! \nYour redeem Code is : " + redeemCode
				+ "\nThe Link is : " + endpoint;
	}
}

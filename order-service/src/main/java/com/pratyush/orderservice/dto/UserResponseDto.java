package com.pratyush.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
	
	private String userId;

	private String userName;

	private String address;

	private String phoneNumber;

	private String emailId;

	private String password;

	private double yoyoBalance;


	@Override
	public String toString() {
		return "UserResponseDto [userId=" + userId + ", userName=" + userName + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", password=" + password + ", yoyoBalance="
				+ yoyoBalance + "]";
	}


}

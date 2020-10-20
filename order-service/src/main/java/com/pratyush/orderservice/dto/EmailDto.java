package com.pratyush.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {
	private String userEmail;
	private String recipientEmail;
	private String userPassword;

}

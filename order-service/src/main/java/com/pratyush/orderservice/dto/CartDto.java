package com.pratyush.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
	private int cartId;
	private String userId;
	private String redeemCode;
	private double totalAmount;
	private boolean paymentStatus;
	private String userEmail;
	private String recipientEmail;
	private String userPassword;
	private List<ProductDto> allSelectedProduct;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartDto other = (CartDto) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}

}

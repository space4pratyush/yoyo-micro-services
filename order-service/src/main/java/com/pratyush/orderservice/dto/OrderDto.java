package com.pratyush.orderservice.dto;

import com.pratyush.orderservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
	private Date purchaseDate;
	private String redeemCode;
	private List<Product> allSelectedProduct;

}

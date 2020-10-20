package com.pratyush.productservice.dto;

import lombok.Data;

@Data
public class ProductStatus {
	private int productId;
	private double productPrice;
	private String productDescription;
	private int productQuantity;
	private String status;
	private ModelDto productModel;
}

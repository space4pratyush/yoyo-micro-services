package com.pratyush.productservice.dto;

import lombok.Data;

@Data
public class ProductDto{
	private int productId;
	private double productPrice;
	private String productDescription;
	private int productQuantity;
	private ModelDto productModel;
}

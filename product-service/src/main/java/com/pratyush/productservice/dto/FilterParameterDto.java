package com.pratyush.productservice.dto;

import lombok.Data;

@Data
public class FilterParameterDto {
	private double productId;
	private String categoryName;
	private String brandName;
	private String modelName;
	private double minPrice;
	private double maxPrice;
}

package com.pratyush.productservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ModelDto {
	private int modelId;
	private String modelName;
	private BrandDto modelBrand;
	private List<ProductDto> productList;

}

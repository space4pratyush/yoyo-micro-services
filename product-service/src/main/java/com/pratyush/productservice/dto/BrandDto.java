package com.pratyush.productservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class BrandDto {
	private int brandId;
	private String brandName;
	private CategoryDto brandCategory;
	private List<ModelDto> ModelList;

}

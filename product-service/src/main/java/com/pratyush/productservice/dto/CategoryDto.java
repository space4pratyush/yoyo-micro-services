package com.pratyush.productservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
	private int categoryId;
	private String categoryName;
	private List<BrandDto> brandList;

}

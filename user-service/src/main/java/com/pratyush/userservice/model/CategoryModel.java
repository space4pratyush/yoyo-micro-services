package com.pratyush.userservice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CategoryModel {
	private int categoryId;
	private String categoryName;
	@JsonIgnore
	private List<BrandModel> brandList;
	public CategoryModel() {
		super();
		// constructor
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<BrandModel> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<BrandModel> brandList) {
		this.brandList = brandList;
	}
	
}

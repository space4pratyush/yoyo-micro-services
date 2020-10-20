package com.pratyush.userservice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BrandModel {
	private int brandId;
	private String brandName;
	private CategoryModel brandCategory;
	@JsonIgnore
	private List<ModelModel> ModelList;

	public BrandModel() {
		super();
		// constructor
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public CategoryModel getBrandCategory() {
		return brandCategory;
	}

	public void setBrandCategory(CategoryModel brandCategory) {
		this.brandCategory = brandCategory;
	}

	public List<ModelModel> getModelList() {
		return ModelList;
	}

	public void setModelList(List<ModelModel> modelList) {
		ModelList = modelList;
	}

}

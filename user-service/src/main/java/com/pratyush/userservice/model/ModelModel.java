package com.pratyush.userservice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ModelModel {
	private int modelId;
	private String modelName;
	@JsonIgnoreProperties("modelList")
	private BrandModel modelBrand;
	@JsonIgnore
	private List<ProductModel> productList;

	public ModelModel() {
		super();
		//constructor
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public BrandModel getModelBrand() {
		return modelBrand;
	}

	public void setModelBrand(BrandModel modelBrand) {
		this.modelBrand = modelBrand;
	}

	public List<ProductModel> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductModel> productList) {
		this.productList = productList;
	}

}

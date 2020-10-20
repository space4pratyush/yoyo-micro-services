package com.pratyush.productservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Model {
	@Id
	private int modelId;
	private String modelName;
	private Brand modelBrand;
	private List<Product> productList;

}

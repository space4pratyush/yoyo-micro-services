package com.pratyush.productservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Brand {

	@Id
	private int brandId;
	private String brandName;
	private Category brandCategory;
	private List<Model> ModelList;

}

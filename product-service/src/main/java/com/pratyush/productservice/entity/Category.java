package com.pratyush.productservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Category {

	@Id
	private int categoryId;
	private String categoryName;
	private List<Brand> brandList;

}

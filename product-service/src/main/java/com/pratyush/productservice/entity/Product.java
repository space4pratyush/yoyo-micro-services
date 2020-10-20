package com.pratyush.productservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Product implements Comparable<Product> {

	@Id
	private int productId;
	private double productPrice;
	private Model productModel;
	private int productQuantity;
	private String productDescription;

	@Override
	public int compareTo(Product arg0) {
		return (int) (this.productPrice-arg0.productPrice);
	}



}

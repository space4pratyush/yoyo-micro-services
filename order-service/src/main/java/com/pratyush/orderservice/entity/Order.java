package com.pratyush.orderservice.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Order {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private long orderId;
	private String userId;
	private Date purchaseDate;
	private Date redeemDate;
	private String redeemCode;
	private List<Product> allSelectedProduct;

}

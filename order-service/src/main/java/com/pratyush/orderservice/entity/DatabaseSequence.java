package com.pratyush.orderservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class DatabaseSequence {

	 @Id
	 private String orderId;
	 
	 private long seq;
}

package com.pratyush.securityservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Document
public class User implements Serializable{	

	private static final long serialVersionUID = 1L;

	@Id
	private String userId;

	private String userName;

	private String userAddress;

	private String userPhoneNumber;

	private String userEmailId;

	private String userPassword;

	private double yoyoBalance;

	private String passwordBycrptor;

	public User() {
	}
}
package com.pratyush.userservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {

    @Id
    private String userId;

    private String userName;

    private String address;

    private String phoneNumber;

    @Indexed(unique = true)
    private String emailId;

    private String password;

    private Double yoyoBalance;

    private String passwordBycryptor;
}

package com.pratyush.userservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String userId;

    private String userName;

    private String address;

    private String phoneNumber;

    private String emailId;

    private String password;
}

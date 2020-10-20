package com.pratyush.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileDto {

    private String userName;

    private String address;

    private String phoneNumber;

    private String emailId;

}

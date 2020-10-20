package com.pratyush.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {

    private String message;

    private List<String> errorSignUp;

    private List<String> validInputDetails;

}

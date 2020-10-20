package com.pratyush.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto extends ResponseMessageDto{

    private String userId;

    private String userName;

    private String yoYoBalance;
}

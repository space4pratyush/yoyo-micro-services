package com.pratyush.userservice.dto;

import lombok.Data;

@Data
public class AddYoyoBalanceDto extends ResponseMessageDto{

    private int amountToBuyPoints;

    private String userName;

    private double PointsPurchased;

    private double yoYoBalance;
}

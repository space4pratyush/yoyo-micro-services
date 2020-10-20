package com.pratyush.orderservice.service;

import java.util.List;

import com.pratyush.orderservice.dto.CartDto;
import com.pratyush.orderservice.dto.MessageBody;
import com.pratyush.orderservice.dto.OrderDto;
import com.pratyush.orderservice.dto.ProductDto;

public interface OrderService {

	OrderDto purchaseProductService(CartDto cartDto);

	List<ProductDto> getGiftService(String redeemCode);

	void emailService(CartDto cartDto, MessageBody messageBody);

}

package com.pratyush.orderservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.pratyush.orderservice.dto.*;
import com.pratyush.orderservice.feign.CartProxy;
import com.pratyush.orderservice.feign.ProductProxy;
import com.pratyush.orderservice.feign.RedeemProxy;
import com.pratyush.orderservice.feign.UserProxy;
import com.pratyush.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import feign.FeignException;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@Autowired
	ProductProxy productProxy;

	@Autowired
	UserProxy userProxy;
	
	@Autowired
	RedeemProxy redeemProxy;
	
	@Autowired
	CartProxy cartProxy;

	@PostMapping("/purchase")
	ResponseEntity purchaseProductController(@RequestBody CartDto cartDto) {
		try {
			List<ProductDto> productDtoList = cartDto.getAllSelectedProduct().stream().collect(Collectors.toList());

			ResponseDto responseDto= productProxy.verifyProductController(productDtoList).getBody();
			UserResponseDto userResponseDto = userProxy.verifyYoyoBalanceController(cartDto.getTotalAmount(), cartDto.getUserId()).getBody();
			responseDto = productProxy.purchasedProductController(productDtoList).getBody();

			String redeemCode=redeemProxy.generateRedeemCode(cartDto.getUserId(), cartDto.getCartId()).getBody();
			cartDto.setRedeemCode(redeemCode);
			String status=cartProxy.setPaymentStatus(cartDto.getCartId()).getBody();
		   orderService.emailService(cartDto,new MessageBody(cartDto.getRedeemCode(),"52.170.27.18:8082/redeemProduct/{userId}/{redeemId}"));
			return new ResponseEntity(orderService.purchaseProductService(cartDto), HttpStatus.OK);
		} catch (FeignException e) {
		HttpStatus status = HttpStatus.resolve(e.status());
			if (status == null) {
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
			return new ResponseEntity(e.contentUTF8(), status);
		}
	}
	
	@GetMapping("/giftlist/{redeemCode}")
	public List<ProductDto> getGiftController(@PathVariable String redeemCode) {
		return orderService.getGiftService(redeemCode);
	}
	
	
}

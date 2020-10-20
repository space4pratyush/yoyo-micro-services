package com.pratyush.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="cartservice")
public interface CartProxy {
	
	@PutMapping("/cart/status/{cartId}")
	public ResponseEntity<String> setPaymentStatus(@PathVariable int cartId);
	
}

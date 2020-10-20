package com.pratyush.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="redeemservice")
public interface RedeemProxy {
	
	@PostMapping("/redeem/generateRedeemCode/{userId}/{cartId}")
	ResponseEntity<String> generateRedeemCode(@PathVariable String userId, @PathVariable int cartId);
}

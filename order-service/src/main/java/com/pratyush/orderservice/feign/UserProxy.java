package com.pratyush.orderservice.feign;

import com.pratyush.orderservice.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(name = "userservice")
public interface UserProxy {

	@PutMapping("/user/verifybalance/{yoyoBalance}/{userId}")  
	ResponseEntity<UserResponseDto> verifyYoyoBalanceController(@PathVariable double yoyoBalance,
																@PathVariable String userId);
}

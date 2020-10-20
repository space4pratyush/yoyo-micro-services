package com.pratyush.orderservice.feign;

import java.util.List;

import com.pratyush.orderservice.dto.ProductDto;
import com.pratyush.orderservice.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="productservice")
public interface ProductProxy {
	
	@PostMapping("filter/verify")
	ResponseEntity<ResponseDto> verifyProductController(@RequestBody List<ProductDto> productDtoList);
	
	@PostMapping("filter/purchased")
	ResponseEntity<ResponseDto> purchasedProductController(@RequestBody List<ProductDto> productDtoList);
	
}

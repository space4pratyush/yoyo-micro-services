package com.pratyush.giftservice.proxy;

import java.util.List;

import com.pratyush.giftservice.model.ProductModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="orderservice")
public interface OrderProxy {
	
	@GetMapping("/order/giftlist/{redeemCode}")
	public List<ProductModel> getGiftController(@PathVariable String redeemCode);
}

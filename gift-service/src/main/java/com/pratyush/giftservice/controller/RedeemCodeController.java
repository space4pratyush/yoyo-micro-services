package com.pratyush.giftservice.controller;

import java.util.List;

import com.pratyush.giftservice.GiftServiceApplication;
import com.pratyush.giftservice.entity.RedeemCode;
import com.pratyush.giftservice.entity.RedeemProducts;
import com.pratyush.giftservice.exception.InvalidRedeemCode;
import com.pratyush.giftservice.exception.ServiceException;
import com.pratyush.giftservice.model.ProductModel;
import com.pratyush.giftservice.proxy.OrderProxy;
import com.pratyush.giftservice.service.RedeemService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/redeem")
public class RedeemCodeController {
	@Autowired
	private RedeemService redeemService;
	@Autowired
	private OrderProxy orderproxy;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GiftServiceApplication.class);

	@PostMapping("/generateRedeemCode/{userId}/{cartId}")
	public ResponseEntity<String> generateRedeemCode(@PathVariable String userId, @PathVariable int cartId) {
		logger.info("Now Excecuting a Method Of Generating redeem Code");
		System.out.println("generating code");
		RedeemCode redeemCode=redeemService.generateRedeemCode(userId, cartId);
		return new ResponseEntity<String>(redeemCode.getRedeemCode(),HttpStatus.OK);
	}

	@PostMapping("/redeemProduct/{userId}/{redeemId}")
	public RedeemProducts redeemProduct(@PathVariable String userId, @PathVariable String redeemId)
			throws ServiceException {
		if (redeemService.validateRedeemCode(redeemId)) {
			logger.info("Redeem Products process going on..");
			List<ProductModel> products = orderproxy.getGiftController(redeemId);
			RedeemProducts redeemProducts = new RedeemProducts();
			redeemProducts.setUserId(userId);
			redeemProducts.setRedeemCode(redeemId);
			redeemProducts.setProducts(products);
			return redeemService.redeemProducts(redeemProducts);
		} else {
			throw new InvalidRedeemCode();
		}

	}

}

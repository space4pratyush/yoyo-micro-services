package com.pratyush.giftservice.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import com.pratyush.giftservice.exception.ErrorConstatns;
import com.pratyush.giftservice.exception.InvalidRedeemCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice(assignableTypes = RedeemCodeController.class)
public class RedeemCodeExceptionHandler {
	@ExceptionHandler(InvalidRedeemCode.class)
	public ResponseEntity InvalidCode(Exception e, Throwable t) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("Error", true);
		response.put("Message", ErrorConstatns.INVALID_REDEEMCODE);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
	}

}

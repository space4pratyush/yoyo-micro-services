package com.pratyush.productservice.controller;

import com.pratyush.productservice.dto.FilterParameterDto;
import com.pratyush.productservice.dto.ProductDto;
import com.pratyush.productservice.dto.ResponseDto;
import com.pratyush.productservice.exception.ProductException;
import com.pratyush.productservice.exception.service.ServiceException;
import com.pratyush.productservice.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/filter")
public class ProductController {
	@Autowired
	private ProductService productService;

	private static Logger logger = LogManager.getLogger(ProductController.class);

	@GetMapping("/getProduct")
	public ResponseEntity<ResponseDto> getProductController(@RequestBody FilterParameterDto filterParameterDto)
			throws ProductException {
		try {
			logger.info("Filtering by Id");
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(productService.getProductService((int) filterParameterDto.getProductId())),
					HttpStatus.OK);
		} catch (ServiceException e) {
			throw new ProductException(e.getMessage());
		}
	}

	@GetMapping("/price")
	public ResponseEntity<ResponseDto> filterByPriceController(@RequestBody FilterParameterDto filterParameterDto)
			throws ProductException {
		try {
			logger.info("Filtering by price");

			return new ResponseEntity<ResponseDto>(new ResponseDto(productService
					.filterByPriceService(filterParameterDto.getMinPrice(), filterParameterDto.getMaxPrice())),
					HttpStatus.OK);
		} catch (ServiceException e) {
			throw new ProductException(e.getMessage());
		}
	}

	@GetMapping("/view")
	public ResponseEntity<ResponseDto> viewProductController() {
		logger.info("Getting All products");
		return new ResponseEntity<ResponseDto>(new ResponseDto("ALL_PRODUCTS", productService.viewProductService()),
				HttpStatus.OK);
	}

	@PostMapping("/purchased")
	public ResponseEntity<ResponseDto> purchasedProductController(@RequestBody List<ProductDto> productDtoList)
			throws ProductException {
		try {
			logger.info("Updating purchased Products");
			return new ResponseEntity<ResponseDto>(
					new ResponseDto("PURCHASED", productService.purchasedProductService(productDtoList)),
					HttpStatus.OK);
		} catch (ServiceException e) {
			throw new ProductException(e.getMessage());
		}
	}

	@PostMapping("/verify")
	public ResponseEntity<ResponseDto> verifyProductController(@RequestBody List<ProductDto> productDtoList)
			throws ProductException {
		try {
			logger.warn("Preparing for Product verification");
			return new ResponseEntity<ResponseDto>(
					new ResponseDto("VERIFICATION_SUCCESS", productService.verifyProductService(productDtoList)),
					HttpStatus.OK);
		} catch (ServiceException e) {
			throw new ProductException(e.getMessage());
		}
	}
	

}

package com.pratyush.productservice.controller;

import com.pratyush.productservice.dto.FilterParameterDto;
import com.pratyush.productservice.dto.ResponseDto;
import com.pratyush.productservice.exception.ProductException;
import com.pratyush.productservice.exception.service.ServiceException;
import com.pratyush.productservice.service.BrandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filter")
public class BrandController {
	@Autowired
	private BrandService brandService;

	private static Logger logger = LogManager.getLogger(BrandController.class);

	@GetMapping("/brand")
	public ResponseEntity<ResponseDto> filterByBrandController(@RequestBody FilterParameterDto filterParameterDto)
			throws ProductException {
		try {
			logger.info("Filtering by brandName");
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(brandService.filterByBrandService(filterParameterDto.getBrandName())),
					HttpStatus.OK);
		} catch (ServiceException e) {
			throw new ProductException(e.getMessage());
		}
	}

	@GetMapping("/brand/model")
	public ResponseEntity<ResponseDto> filterByBrandModelController(@RequestBody FilterParameterDto filterParameterDto)
			throws ProductException {
		try {
			logger.info("Filtering by brandName and modelName");
			return new ResponseEntity<ResponseDto>(new ResponseDto(brandService
					.filterByBrandModelService(filterParameterDto.getBrandName(), filterParameterDto.getModelName())),
					HttpStatus.OK);
		} catch (ServiceException e) {
			throw new ProductException(e.getMessage());
		}
	}

	@GetMapping("/brand/model/price")
	public ResponseEntity<ResponseDto> filterByBrandModelPriceController(
			@RequestBody FilterParameterDto filterParameterDto) throws ProductException {
		try {
			logger.info("Filtering by brandName and modelName and price");
			return new ResponseEntity<ResponseDto>(new ResponseDto(brandService.filterByBrandModelPriceService(
					filterParameterDto.getBrandName(), filterParameterDto.getModelName(),
					filterParameterDto.getMinPrice(), filterParameterDto.getMaxPrice())), HttpStatus.OK);
		} catch (ServiceException e) {
			throw new ProductException(e.getMessage());
		}
	}

	@GetMapping("/brand/price")
	public ResponseEntity<ResponseDto> filterByBrandPriceController(@RequestBody FilterParameterDto filterParameterDto)
			throws ProductException {
		try {
			logger.info("Filtering by brandName and modelName and price");
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(brandService.filterByBrandPriceService(filterParameterDto.getBrandName(),
							filterParameterDto.getMinPrice(), filterParameterDto.getMaxPrice())),
					HttpStatus.OK);
		} catch (ServiceException e) {
			throw new ProductException(e.getMessage());
		}
	}

}

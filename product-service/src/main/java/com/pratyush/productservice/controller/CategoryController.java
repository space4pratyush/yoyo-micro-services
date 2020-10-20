package com.pratyush.productservice.controller;

import com.pratyush.productservice.dto.FilterParameterDto;
import com.pratyush.productservice.dto.ResponseDto;
import com.pratyush.productservice.exception.ProductException;
import com.pratyush.productservice.exception.service.ServiceException;
import com.pratyush.productservice.service.CategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/filter")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	private static Logger logger = LogManager.getLogger(CategoryController.class);

	/**
	 * @param filterParameterDto
	 * @return
	 * @throws ProductException
	 */
	@GetMapping("/category")
	public ResponseEntity<ResponseDto> filterByCategoryController(@RequestBody FilterParameterDto filterParameterDto)
			throws ProductException {
		try {
			logger.info("Filtering by categoryName");
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(categoryService.filterByCategoryService(filterParameterDto.getCategoryName())),
					HttpStatus.OK);
		} catch (ServiceException e) {
			throw new ProductException(e.getMessage());
		}
	}

	/**
	 * @param filterParameterDto
	 * @return
	 * @throws ProductException
	 */
	@GetMapping("/category/price")
	public ResponseEntity<ResponseDto> filterByCategoryPriceController(
			@RequestBody FilterParameterDto filterParameterDto) throws ProductException {
		try {
			logger.info("Filtering by categoryName and price");
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(categoryService.filterByCategoryPriceService(filterParameterDto.getCategoryName(),
							filterParameterDto.getMinPrice(), filterParameterDto.getMaxPrice())),
					HttpStatus.OK);
		} catch (ServiceException e) {
			throw new ProductException(e.getMessage());
		}
	}

	@GetMapping("/category/brand")
	public ResponseEntity<ResponseDto> filterByCategoryBrandController(
			@RequestBody FilterParameterDto filterParameterDto) throws ProductException {
		try {
			logger.info("Filtering by categoryName and brandName");
			return new ResponseEntity<ResponseDto>(new ResponseDto(categoryService.filterByCategoryBrandService(
					filterParameterDto.getCategoryName(), filterParameterDto.getBrandName())), HttpStatus.OK);
		} catch (ServiceException e) {
			throw new ProductException(e.getMessage());
		}
	}

	@GetMapping("/category/brand/price")
	public ResponseEntity<ResponseDto> filterByCategoryBrandPriceController(
			@RequestBody FilterParameterDto filterParameterDto) throws ProductException {
		try {
			logger.info("Filtering by categoryName and brandName and price");
			return new ResponseEntity<ResponseDto>(new ResponseDto(categoryService.filterByCategoryBrandPriceService(
					filterParameterDto.getCategoryName(), filterParameterDto.getBrandName(),
					filterParameterDto.getMinPrice(), filterParameterDto.getMaxPrice())), HttpStatus.OK);
		} catch (ServiceException e) {
			throw new ProductException(e.getMessage());
		}
	}
}

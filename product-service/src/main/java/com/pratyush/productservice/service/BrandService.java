package com.pratyush.productservice.service;

import java.util.List;

import com.pratyush.productservice.dto.ProductDto;
import com.pratyush.productservice.exception.service.ServiceException;

public interface BrandService {

	List<ProductDto> filterByBrandService(String brandName) throws ServiceException;

	List<ProductDto> filterByBrandModelService(String brandName, String modelName) throws ServiceException;

	List<ProductDto> filterByBrandModelPriceService(String brandName, String modelName, double minPrice,
			double maxPrice) throws ServiceException;

	List<ProductDto> filterByBrandPriceService(String brandName, double minPrice, double maxPrice) throws ServiceException;

}

package com.pratyush.productservice.service;

import com.pratyush.productservice.dto.ProductDto;
import com.pratyush.productservice.exception.service.ServiceException;

import java.util.List;

public interface CategoryService {

	List<ProductDto> filterByCategoryService(String categoryName) throws ServiceException;

	List<ProductDto> filterByCategoryPriceService(String categoryName,double minPrice,double maxPrice) throws ServiceException;

	List<ProductDto> filterByCategoryBrandPriceService(String categoryName, String brandName, double minPrice,
			double maxPrice) throws ServiceException;

	List<ProductDto> filterByCategoryBrandService(String categoryName, String brandName) throws ServiceException;

}

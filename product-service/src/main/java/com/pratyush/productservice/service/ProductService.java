package com.pratyush.productservice.service;

import java.util.List;

import com.pratyush.productservice.dto.ProductDto;
import com.pratyush.productservice.dto.ProductStatus;
import com.pratyush.productservice.exception.service.ServiceException;

public interface ProductService {

	ProductDto getProductService(int productId) throws ServiceException;

	List<ProductDto> filterByPriceService(double minPrice,double maxPrice) throws ServiceException;

	List<ProductDto> viewProductService();

	List<ProductStatus> purchasedProductService(List<ProductDto> productDtoList) throws ServiceException;

	List<ProductDto> verifyProductService(List<ProductDto> productDtoList) throws ServiceException;

}

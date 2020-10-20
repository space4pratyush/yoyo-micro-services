package com.pratyush.productservice.service;

import java.util.List;
import com.pratyush.productservice.dto.ProductDto;
import com.pratyush.productservice.exception.service.ServiceException;

public interface ModelService {

	List<ProductDto> filterByModelService(String modelName) throws ServiceException;

	List<ProductDto> filterByModelPriceService(String modelName, double minPrice, double maxPrice) throws ServiceException;

}

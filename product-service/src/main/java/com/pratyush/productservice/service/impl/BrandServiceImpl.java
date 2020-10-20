package com.pratyush.productservice.service.impl;


import com.pratyush.productservice.dto.ProductDto;
import com.pratyush.productservice.entity.Brand;
import com.pratyush.productservice.entity.Model;
import com.pratyush.productservice.entity.Product;
import com.pratyush.productservice.exception.service.*;
import com.pratyush.productservice.repository.BrandRepository;
import com.pratyush.productservice.service.BrandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

	private static Logger logger = LogManager.getLogger(BrandServiceImpl.class);

	private BrandRepository brandRepository;

	@Autowired
	public BrandServiceImpl(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	private ModelMapper mapper = new ModelMapper();

	@Override
	@Cacheable(value = "brand", key = "#p0", condition = "#p0!=null")
	@Transactional(readOnly = true)
	public List<ProductDto> filterByBrandService(String brandName) throws ServiceException {
		try {
			List<ProductDto> productDtoList = new ArrayList<>();
			Pageable pageable = PageRequest.of(0, 40);
			List<Brand> brandList = brandRepository.findByBrandName(brandName, pageable);
			logger.warn("Verifying brandName");
			if (brandList.size() == 0) {
				logger.error("Invalid brandName");
				throw new InvalidBrandException("INVALID_BRAND");
			}
			Brand brand = brandList.get(0);
			for (Model model : brand.getModelList()) {
				for (Product product : model.getProductList()) {
					productDtoList.add(mapper.map(product, ProductDto.class));
				}
			}
			logger.trace("Getting Products ...");
			return productDtoList;
		} catch (InvalidBrandException ex) {
			throw new ServiceException(ex.getMessage());
		}
	}

	@Override
	@Cacheable(value = "brand", key = "#modelName + #brandName", condition = "#modelName!=null && #brandName!=null")
	@Transactional(readOnly = true)
	public List<ProductDto> filterByBrandModelService(String brandName, String modelName) throws ServiceException {

		try {
			List<ProductDto> productDtoList = new ArrayList<ProductDto>();
			Pageable pageable = PageRequest.of(0, 20);
			List<Brand> brandList = brandRepository.findByBrandName(brandName, pageable);
			logger.warn("Verifying brandName and modelName");
			if (brandList.size() == 0) {
				logger.error("Invalid brandName");
				throw new InvalidBrandException("INVALID_BRAND");
			}
			boolean modelFlag = false;
			Brand brand = brandList.get(0);
			for (Model model : brand.getModelList()) {
				if (modelName.equalsIgnoreCase(model.getModelName())) {
					modelFlag = true;
					if (model.getProductList().size() == 0) {
						logger.error("No products available");
						throw new NoProductFoundException("NO_MODEL_BRAND");
					}
					for (Product product : model.getProductList()) {
						productDtoList.add(mapper.map(product, ProductDto.class));
					}
				}
			}
			if (modelFlag == false) {
				logger.error("Invalid modelName");
				throw new InvalidModelException("INVALID_MODEL");
			}
			logger.trace("Getting Products ...");
			return productDtoList;
		} catch (InvalidBrandException | NoProductFoundException ex) {
			throw new ServiceException(ex.getMessage());
		}
	}

	@Override
	@Cacheable(value = "brand", key = "#minPrice + #brandName + #maxPrice + #modelName", condition = "#minPrice!=null && #brandName!=null && #maxPrice!=null && #modelName!=null")
	@Transactional(readOnly = true)
	public List<ProductDto> filterByBrandModelPriceService(String brandName, String modelName, double minPrice,
			double maxPrice) throws ServiceException {
		try {
			validatePrice(minPrice, maxPrice);
			List<ProductDto> productDtoList = new ArrayList<ProductDto>();
			Pageable pageable = PageRequest.of(0, 20);
			List<Brand> brandList = brandRepository.findByBrandName(brandName, pageable);
			if (brandList.size() == 0) {
				logger.error("Invalid Brand");
				throw new InvalidBrandException("INVALID_BRAND");
			}
			boolean modelFlag = false;
			Brand brand = brandList.get(0);
			for (Model model : brand.getModelList()) {
				if (modelName.equalsIgnoreCase(model.getModelName())) {
					modelFlag = true;
					if (model.getProductList().size() == 0) {
						logger.fatal("No Product available");
						throw new NoProductFoundException("NO_MODEL_BRAND");
					}
					for (Product product : model.getProductList()) {
						if (product.getProductPrice() >= minPrice && product.getProductPrice() <= maxPrice)
							productDtoList.add(mapper.map(product, ProductDto.class));
					}
				}
			}
			if (modelFlag == false) {
				logger.error("Invalid ModelName");
				throw new InvalidModelException("INVALID_MODEL");
			}
			if (productDtoList.size() == 0) {
				logger.fatal("No Product available");
				throw new NoProductFoundException("INVALID_RANGE");
			}
			logger.trace("Getting Products ...");
			return productDtoList;
		} catch (InvalidBrandException | NoProductFoundException | InvalidRangeException ex) {
			throw new ServiceException(ex.getMessage());
		}
	}

	@Override
	@Cacheable(value = "brand", key = "#minPrice + #brandName + #maxPrice", condition = "#minPrice!=null && #brandName!=null && #maxPrice!=null")
	@Transactional(readOnly = true)
	public List<ProductDto> filterByBrandPriceService(String brandName, double minPrice, double maxPrice)
			throws ServiceException {
		try {
			validatePrice(minPrice, maxPrice);
			List<ProductDto> productDtoList = new ArrayList<ProductDto>();
			Pageable pageable = PageRequest.of(0, 20);
			List<Brand> brandList = brandRepository.findByBrandName(brandName, pageable);

			if (brandList.size() == 0) {
				logger.error("Invalid brandName");
				throw new InvalidBrandException("INVALID_BRAND");
			}
			Brand brand = brandList.get(0);
			for (Model model : brand.getModelList()) {
				for (Product product : model.getProductList()) {
					if (product.getProductPrice() >= minPrice && product.getProductPrice() <= maxPrice)
						productDtoList.add(mapper.map(product, ProductDto.class));
				}

			}
			if (productDtoList.size() == 0) {
				logger.fatal("No Product available");
				throw new NoProductFoundException("INVALID_RANGE");
			}
			logger.trace("Getting Products ...");
			return productDtoList;
		} catch (InvalidBrandException | NoProductFoundException | InvalidRangeException ex) {
			throw new ServiceException(ex.getMessage());
		}
	}

	private void validatePrice(double minPrice, double maxPrice) throws InvalidRangeException {
		logger.warn("Validating brandName and price-range");
		if (minPrice >= maxPrice) {
			logger.error("Invalid Price-Range");
			throw new InvalidRangeException("NEGATIVE_RANGE");
		}
		return;
	}

}

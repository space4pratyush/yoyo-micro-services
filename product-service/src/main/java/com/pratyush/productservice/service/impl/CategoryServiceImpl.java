package com.pratyush.productservice.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.pratyush.productservice.dto.ProductDto;
import com.pratyush.productservice.entity.Brand;
import com.pratyush.productservice.entity.Category;
import com.pratyush.productservice.entity.Model;
import com.pratyush.productservice.entity.Product;
import com.pratyush.productservice.exception.service.*;
import com.pratyush.productservice.repository.CategoryRepository;
import com.pratyush.productservice.service.CategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

	private static Logger logger=LogManager.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	private CategoryRepository categoryRepository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	@Cacheable(value = "category",key="#categoryName", condition="#categoryName!=null")
	@Transactional(readOnly = true)
	public List<ProductDto> filterByCategoryService(String categoryName) throws ServiceException {
		try {
			 logger.warn("Validating categoryName");
			long count=categoryRepository.count();
			Pageable pageable = PageRequest.of(0, (int)count);
			List<Category> categoryList = categoryRepository.findByCategoryName(categoryName, pageable);
			if (categoryList.size() == 0) {
				logger.error("Invalid categoryName");
				throw new InvalidCategoryException("INVALID_CATEGORY");
			}
			Category category = categoryList.get(0);
			List<ProductDto> productDtoList = new ArrayList<ProductDto>();
			List<Product> productList=new ArrayList<Product>();
			for (Brand brand : category.getBrandList()) {
				for (Model model : brand.getModelList()) {
					for (Product product : model.getProductList()) {
						productList.add(product);
					}
				}
			}
			Collections.sort(productList);
			for (Product product : productList) {
				productDtoList.add(mapper.map(product, ProductDto.class));
			}
			logger.trace("Getting Products.....");
			return productDtoList;
		} catch (InvalidCategoryException sx) {
			throw new ServiceException(sx.getMessage());
		}
	}

	@Override
	@Cacheable(value = "category",key="#minPrice + #maxPrice + #categoryName", condition = "#minPrice!=null && #maxPrice!=null && #categoryName!=null")
	@Transactional(readOnly = true)
	public List<ProductDto> filterByCategoryPriceService(String categoryName, double minPrice, double maxPrice)
			throws ServiceException {
		try {
			logger.warn("Validating categoryName and price-range");
			if(minPrice>=maxPrice) {
				logger.error("Invalid price-range");
				throw new InvalidRangeException("NEGATIVE_RANGE");
			}
			long count=categoryRepository.count();
			Pageable pageable = PageRequest.of(0, (int)count);
			List<Category> categoryList = categoryRepository.findByCategoryName(categoryName, pageable);
			if (categoryList.size() == 0) {
				logger.error("Invalid categoryName");
				throw new InvalidCategoryException("INVALID_CATEGORY");
			}
			Category category = categoryList.get(0);
			List<ProductDto> productDtoList = new ArrayList<ProductDto>();
			List<Product> productList=new ArrayList<Product>();
			for (Brand brand : category.getBrandList()) {
				for (Model model : brand.getModelList()) {
					for (Product product : model.getProductList()) {
						if (product.getProductPrice() > minPrice && product.getProductPrice() < maxPrice) {
							productList.add(product);
						}
					}
				}
			}
			Collections.sort(productList);
			for (Product product : productList) {
				productDtoList.add(mapper.map(product, ProductDto.class));
			}
			if (productDtoList.size() == 0) {
				logger.fatal("No Products Found");
				throw new NoProductFoundException("INVALID_RANGE");
			}
			logger.trace("Getting Products.....");
			return productDtoList;
		} catch (InvalidCategoryException | NoProductFoundException|InvalidRangeException ex) {
			throw new ServiceException(ex.getMessage());
		}
	}

	@Override
	@Cacheable(value = "category",key="#maxPrice + #minPrice + #categoryName + #brandName", condition ="#maxPrice!=null #minPrice!=null && #categoryName!=null && #brandName!=null")
	@Transactional(readOnly = true)
	public List<ProductDto> filterByCategoryBrandPriceService(String categoryName, String brandName, double minPrice,
			double maxPrice) throws ServiceException {
		try {
			logger.warn("Validating categoryName, brandName and price");
			if(minPrice>=maxPrice) {
				logger.error("Invalid price-range");
				throw new InvalidRangeException("NEGATIVE_RANGE");
			}
			long count=categoryRepository.count();
			Pageable pageable = PageRequest.of(0, (int)count);
			List<Category> categoryList = categoryRepository.findByCategoryName(categoryName, pageable);
			if (categoryList.size() == 0) {
				logger.error("Invalid categoryName");
				throw new InvalidCategoryException("INVALID_CATEGORY");
			}
			Category category = categoryList.get(0);
			List<ProductDto> productDtoList = new ArrayList<ProductDto>();
			List<Product> productList = new ArrayList<Product>();
			boolean brandFlag = false;
			for (Brand brand : category.getBrandList()) {
				if (brand.getBrandName().equalsIgnoreCase(brandName)) {
					brandFlag = true;
					if (brand.getModelList().size() == 0) {
						logger.fatal("No Products Found");
						throw new NoProductFoundException("NO_BRAND_CATEGORY");
					}
					for (Model model : brand.getModelList()) {
						for (Product product : model.getProductList()) {
							if (product.getProductPrice() >= minPrice && product.getProductPrice() <= maxPrice)
								productList.add(product);
						}
					}
				}
			}
			Collections.sort(productList);
			for (Product product : productList) {
				productDtoList.add(mapper.map(product, ProductDto.class));
			}
			if (brandFlag == false) {
				logger.error("Invalid brandName");
				throw new InvalidBrandException("INVALID_BRAND");
			}
			if (productDtoList.size() == 0) {
				logger.fatal("No Products Found");
				throw new NoProductFoundException("INVALID_RANGE");
			}
			logger.trace("Getting Products.....");
			return productDtoList;
		} catch (InvalidCategoryException | NoProductFoundException|InvalidRangeException ex) {
			throw new ServiceException(ex.getMessage());
		}
	}

	@Override
	@Cacheable(value = "category",key="#categoryName + #brandName",condition = "#categoryName!=null && #brandName!=null")
	@Transactional(readOnly = true)
	public List<ProductDto> filterByCategoryBrandService(String categoryName, String brandName)
			throws ServiceException {
		try {
			logger.warn("Validating categoryName and brandName");
			long count=categoryRepository.count();
			Pageable pageable = PageRequest.of(0, (int)count);
			List<Category> categoryList = categoryRepository.findByCategoryName(categoryName, pageable);
			if (categoryList.size() == 0) {
				logger.error("Invalid categoryName");
				throw new InvalidCategoryException("INVALID_CATEGORY");
			}
			boolean brandFlag = false;
			Category category = categoryList.get(0);
			List<ProductDto> productDtoList = new ArrayList<ProductDto>();
			List<Product> productList = new ArrayList<Product>();
			for (Brand brand : category.getBrandList()) {
				if (brandName.equalsIgnoreCase(brand.getBrandName())) {
					brandFlag=true;
					if (brand.getModelList().size() == 0) {
						logger.fatal("No products found");
						throw new NoProductFoundException("NO_BRAND_CATEGORY");
					}
					for (Model model : brand.getModelList()) {
						for (Product product : model.getProductList()) {
							productList.add(product);
						}
					}
				}
			}
			Collections.sort(productList);
			for (Product product : productList) {
				productDtoList.add(mapper.map(product, ProductDto.class));
			}
			if (brandFlag == false) {
				logger.error("Invalid brandName");
				throw new InvalidBrandException("INVALID_BRAND");
			}
			logger.trace("Getting Products.....");
			return productDtoList;
		} catch (InvalidCategoryException | NoProductFoundException ex) {
			throw new ServiceException(ex.getMessage());
		}
	}
}

package com.pratyush.productservice.repository;

import java.util.List;

import com.pratyush.productservice.entity.Brand;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends PagingAndSortingRepository<Brand, Integer> {

	List<Brand> findByBrandName(String brandName, Pageable pageable);


}

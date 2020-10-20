package com.pratyush.productservice.repository;

import java.util.List;

import com.pratyush.productservice.entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
 List<Category> findByCategoryName(String categoryName, Pageable pageable);

}

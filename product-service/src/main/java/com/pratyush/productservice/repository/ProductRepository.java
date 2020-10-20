package com.pratyush.productservice.repository;

import java.util.List;

import com.pratyush.productservice.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

	List<Product> findByProductPrice(double minPrice,double maxPrice, Pageable Pageable);

	Product findByProductId(int i);

	@Query(value = "select p.* from product p order by product_id")
	List<Product> findAllProduct(Pageable pageable);



}

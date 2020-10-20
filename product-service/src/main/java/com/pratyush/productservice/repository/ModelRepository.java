package com.pratyush.productservice.repository;

import java.util.List;

import com.pratyush.productservice.entity.Model;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ModelRepository extends PagingAndSortingRepository<Model, Integer>{

	List<Model> findByModelName(String modelName, Pageable pageable);

}

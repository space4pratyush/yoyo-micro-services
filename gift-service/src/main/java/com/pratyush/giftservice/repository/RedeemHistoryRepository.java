package com.pratyush.giftservice.repository;

import com.pratyush.giftservice.entity.RedeemProducts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RedeemHistoryRepository extends MongoRepository<RedeemProducts, String>{

}

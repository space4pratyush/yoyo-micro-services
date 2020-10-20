package com.pratyush.giftservice.repository;

import com.pratyush.giftservice.entity.RedeemCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedeemRepository extends MongoRepository<RedeemCode, String>{


}

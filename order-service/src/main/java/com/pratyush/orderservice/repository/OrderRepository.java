package com.pratyush.orderservice.repository;

import com.pratyush.orderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {

	Order findByRedeemCode(String redeemCode);

}

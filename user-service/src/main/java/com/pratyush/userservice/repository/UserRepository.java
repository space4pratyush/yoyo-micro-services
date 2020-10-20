package com.pratyush.userservice.repository;

import com.pratyush.userservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserId(String userId);

    boolean existsByEmailId(String emailId);

    boolean existsByPhoneNumber(String phoneNumber);
}

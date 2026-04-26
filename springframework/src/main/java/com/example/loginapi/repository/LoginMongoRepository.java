package com.example.loginapi.repository;

import com.example.loginapi.entity.LoginEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMongoRepository extends MongoRepository<LoginEntity, String> {
}

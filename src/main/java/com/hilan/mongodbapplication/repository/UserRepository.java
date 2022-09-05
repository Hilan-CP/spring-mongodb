package com.hilan.mongodbapplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hilan.mongodbapplication.Entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}

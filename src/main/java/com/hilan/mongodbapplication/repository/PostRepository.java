package com.hilan.mongodbapplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hilan.mongodbapplication.Entity.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}

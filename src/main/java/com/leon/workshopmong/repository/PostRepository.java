package com.leon.workshopmong.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.leon.workshopmong.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}

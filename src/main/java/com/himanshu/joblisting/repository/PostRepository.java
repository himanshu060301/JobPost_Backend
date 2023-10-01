package com.himanshu.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.himanshu.joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
}

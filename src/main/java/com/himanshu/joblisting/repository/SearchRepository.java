package com.himanshu.joblisting.repository;

import java.util.List;

import com.himanshu.joblisting.model.Post;

public interface SearchRepository {
	List<Post> searchByText(String text);
}

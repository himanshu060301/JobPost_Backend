package com.himanshu.joblisting.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.himanshu.joblisting.model.Post;
import com.himanshu.joblisting.repository.PostRepository;
import com.himanshu.joblisting.repository.SearchRepository;

import springfox.documentation.annotations.ApiIgnore;


@RestController
@CrossOrigin(origins="https://jobpost-frontend.onrender.com")
public class PostController {
	
	@Autowired
	PostRepository repo;
	
	@Autowired
	SearchRepository searchRepo;
	
	@ApiIgnore
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse res) throws IOException{
		res.sendRedirect("/swagger-ui.html");
	}
	
	@GetMapping("/allPosts")
	@CrossOrigin
	public List<Post> getAllPosts(){
		return repo.findAll();
		
	}
	
	@GetMapping("/posts/{text}")
	@CrossOrigin
	public List<Post> search(@PathVariable String text){
		return searchRepo.searchByText(text);
		
	}
	
	@PostMapping("/post")
	@CrossOrigin
	public Post addPost(@RequestBody Post post) {
		return repo.save(post);
		
	}
}

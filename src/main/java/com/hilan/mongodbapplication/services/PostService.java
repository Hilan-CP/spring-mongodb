package com.hilan.mongodbapplication.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hilan.mongodbapplication.Entity.Post;
import com.hilan.mongodbapplication.repository.PostRepository;
import com.hilan.mongodbapplication.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repository.findByTitle(text);
	}
	
	public List<Post> searchTextBetweenDate(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
		return repository.searchTextBetweenDate(text, minDate, maxDate);
	}
}

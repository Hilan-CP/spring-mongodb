package com.hilan.mongodbapplication.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hilan.mongodbapplication.Entity.Post;
import com.hilan.mongodbapplication.resources.util.URLString;
import com.hilan.mongodbapplication.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = service.findById(id);
		return ResponseEntity.ok(post);
	}
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text){
		text = URLString.decodeParam(text);
		List<Post> posts = service.findByTitle(text);
		return ResponseEntity.ok(posts);
	}
	
	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> searchTextBetweenDate(@RequestParam(value="text", defaultValue="") String text,
															@RequestParam(value="minDate", defaultValue="") String minDate,
															@RequestParam(value="maxDate", defaultValue="") String maxDate){
		text = URLString.decodeParam(text);
		Date min = URLString.convertDate(minDate, new Date(0L));
		Date max = URLString.convertDate(maxDate, new Date());
		List<Post> posts = service.searchTextBetweenDate(text, min, max);
		return ResponseEntity.ok(posts);
	}
}

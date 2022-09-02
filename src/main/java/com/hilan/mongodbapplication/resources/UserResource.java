package com.hilan.mongodbapplication.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hilan.mongodbapplication.Entity.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		List<User> list = new ArrayList<>();
		
		User u1 = new User("1", "Olá", "ola@email.com");
		User u2 = new User("2", "Tchau", "tchau@email.com");
		
		list.add(u1);
		list.add(u2);
		
		return ResponseEntity.ok(list);
	}
}

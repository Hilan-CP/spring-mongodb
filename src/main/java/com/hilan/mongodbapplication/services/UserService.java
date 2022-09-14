package com.hilan.mongodbapplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hilan.mongodbapplication.Entity.User;
import com.hilan.mongodbapplication.dto.UserDTO;
import com.hilan.mongodbapplication.repository.UserRepository;
import com.hilan.mongodbapplication.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
	
	public User update(User user) {
		User newUser = repository.findById(user.getId()).get();
		updateData(newUser, user);
		return repository.save(newUser);
	}
	
	public User fromDto(UserDTO dto) {
		return new User(dto.getId(), dto.getName(), dto.getEmail());
	}
	
	public void updateData(User newUser, User oldUser) {
		newUser.setName(oldUser.getName());
		newUser.setEmail(oldUser.getEmail());
	}
}

package com.hilan.mongodbapplication.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.hilan.mongodbapplication.Entity.Post;
import com.hilan.mongodbapplication.Entity.User;
import com.hilan.mongodbapplication.dto.AuthorDTO;
import com.hilan.mongodbapplication.dto.CommentDTO;
import com.hilan.mongodbapplication.repository.PostRepository;
import com.hilan.mongodbapplication.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User ana = new User(null, "Ana", "ana@email.com");
		User maria = new User(null, "Maria", "maria@email.com");
		User julia = new User(null, "Julia", "julia@email.com");
		User carlos= new User(null, "Carlos", "carlos@email.com");
		
		userRepository.saveAll(Arrays.asList(ana, maria, julia, carlos));
		
		Post p1 = new Post(null, "Post 1", "Primeiro post", new Date(), new AuthorDTO(ana));
		Post p2 = new Post(null, "Cheguei", "Maria chegando", new Date(), new AuthorDTO(maria));
		Post p3 = new Post(null, "Julia na área", "Olá gente", new Date(), new AuthorDTO(julia));
		Post p4 = new Post(null, "Bom dia", "Hoje eu acordei feliz", new Date(), new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Bom dia linda", new Date(), new AuthorDTO(ana));
		p4.getComments().add(c1);
		
		CommentDTO c2 = new CommentDTO("Exibida", new Date(), new AuthorDTO(carlos));
		p1.getComments().add(c2);
		
		postRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		ana.getPosts().add(p1);
		maria.getPosts().addAll(Arrays.asList(p2, p4));
		julia.getPosts().add(p3);
		
		userRepository.saveAll(Arrays.asList(ana, maria, julia));
	}
}

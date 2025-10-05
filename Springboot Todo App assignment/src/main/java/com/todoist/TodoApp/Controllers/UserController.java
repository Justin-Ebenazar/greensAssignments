package com.todoist.TodoApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoist.TodoApp.entities.UserEntity;
import com.todoist.TodoApp.repository.UserRepository;

import exceptions.ResourceNotFound;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping
	public UserEntity createUser(@RequestBody UserEntity user) { //new user creation
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repo.save(user);
	}
	
	@GetMapping
	public List<UserEntity> getUsers(){ //fetch all users
		return repo.findAll();
	}
	
	@GetMapping("/{id}")//fetch single user
	public UserEntity getUserById(@PathVariable Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFound("User not found with the id : "+id));
	}
	
	
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<?> deleteUser(@PathVariable Long id){
		UserEntity user = repo.findById(id).orElseThrow(() -> new ResourceNotFound("User not found with the id : "+id));
		repo.delete(user);
		return ResponseEntity.ok().build();
	}
	
	
}

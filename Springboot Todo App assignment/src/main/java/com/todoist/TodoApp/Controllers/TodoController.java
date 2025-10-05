package com.todoist.TodoApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoist.TodoApp.entities.TodoEntity;
import com.todoist.TodoApp.entities.UserEntity;
import com.todoist.TodoApp.repository.TodoRepository;
import com.todoist.TodoApp.repository.UserRepository;

import exceptions.ResourceNotFound;

@RestController
@RequestMapping("api/users/{id}/todo")
public class TodoController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TodoRepository todoRepo;
	
	@PostMapping
	public TodoEntity createTodo(@PathVariable Long id,@RequestBody TodoEntity todo) {
		UserEntity user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFound("user not found"));
		todo.setUser(user);
		return todoRepo.save(todo);
		
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<TodoEntity>> fetchTodos(@PathVariable Long id){
		UserEntity user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFound("user not found"));
		return ResponseEntity.ok(user.getTodos());
	}
	
	@GetMapping("/todos/{todoid}")
	public ResponseEntity<TodoEntity> fetchSingleTodo(@PathVariable Long todoid){
		TodoEntity todo = todoRepo.findById(todoid).orElseThrow(() -> new ResourceNotFound("Todo not found"));
		return ResponseEntity.ok(todo);
	}

	@PutMapping("/todos/{todoid}/update")
	public ResponseEntity<TodoEntity> updateStatus(@PathVariable Long todoid){
		TodoEntity todo = todoRepo.findById(todoid).orElseThrow(() -> new ResourceNotFound("Todo not found"));
		todo.setStatus(true);
		return ResponseEntity.ok(todoRepo.save(todo));
	}
	
	@DeleteMapping("/todos/{todoid}/delete")
	public ResponseEntity<TodoEntity> deleteTodo(@PathVariable Long todoid){
		TodoEntity todo = todoRepo.findById(todoid).orElseThrow(() -> new ResourceNotFound("Todo not found"));
		todoRepo.delete(todo);
		return ResponseEntity.ok(todo);
	}
//	@RequestMapping("/hello")
}

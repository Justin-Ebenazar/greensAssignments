package com.todoist.TodoApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoist.TodoApp.entities.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long>{
	Optional<TodoEntity> findTodoById(Long id);
}

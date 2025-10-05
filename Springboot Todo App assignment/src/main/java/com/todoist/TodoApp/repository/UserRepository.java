package com.todoist.TodoApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todoist.TodoApp.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	Optional<UserEntity> findByUserId(Long user_id);
}

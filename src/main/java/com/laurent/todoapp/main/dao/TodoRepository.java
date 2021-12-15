package com.laurent.todoapp.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.laurent.todoapp.main.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	
	List<Todo> findAllByOrderByIdDesc();

}

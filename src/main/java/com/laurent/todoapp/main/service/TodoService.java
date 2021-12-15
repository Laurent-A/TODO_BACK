package com.laurent.todoapp.main.service;

import java.util.List;
import java.util.Optional;

import com.laurent.todoapp.main.dto.TodoDto;
import com.laurent.todoapp.main.exception.ApiNotFoundException;
import com.laurent.todoapp.main.model.Todo;

public interface TodoService {
	
	List<Todo> getAllTodos();

	Optional<Todo> getTodo(Long id);

	Todo updateTodo(Long id, TodoDto todoDto) throws ApiNotFoundException;

}

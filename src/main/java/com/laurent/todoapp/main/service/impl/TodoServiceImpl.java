package com.laurent.todoapp.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laurent.todoapp.main.dao.TodoRepository;
import com.laurent.todoapp.main.model.Todo;
import com.laurent.todoapp.main.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public TodoServiceImpl() {
		super();
	}

	@Override
	public List<Todo> getAllTodos() {
		return this.todoRepository.findAllByOrderByIdDesc();
	}
	

}

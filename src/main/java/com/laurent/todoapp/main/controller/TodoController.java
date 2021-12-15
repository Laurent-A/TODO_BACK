package com.laurent.todoapp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurent.todoapp.main.model.Todo;
import com.laurent.todoapp.main.service.TodoService;

@RestController
@RequestMapping("/todo-app/*")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping(value = "/todos")
	public ResponseEntity<List<Todo>> getAllTodos() {
		List<Todo> todos = todoService.getAllTodos();
		return new ResponseEntity<List<Todo>>(todos, HttpStatus.FOUND);
	}

}

package com.laurent.todoapp.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.laurent.todoapp.main.dto.TodoDto;
import com.laurent.todoapp.main.model.Todo;
import com.laurent.todoapp.main.service.TodoService;

@RestController
@RequestMapping("/todo-app")
@CrossOrigin("*")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping(value = "/todo")
	public ResponseEntity<List<Todo>> getAllTodos() {
		List<Todo> todos = todoService.getAllTodos();
		return new ResponseEntity<List<Todo>>(todos, HttpStatus.OK);
	}
	
	@GetMapping(value="/todo/{id}")
	public ResponseEntity<Todo> getTodo(@PathVariable(value = "id") Long id) {
		Optional<Todo> todoGet = todoService.getTodo(id);
		return new ResponseEntity<Todo>(todoGet.get(), HttpStatus.OK); 
	}

	@PutMapping("/todo/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable(value = "id") Long id, @RequestBody TodoDto todoDto) {
		Todo todoUpdated = todoService.updateTodo(id, todoDto);
		return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
	}

	@PostMapping(value = "/todo")
	public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
		Todo todoAdded = todoService.addTodo(todo);		
 		return new ResponseEntity<Todo>(todoAdded, HttpStatus.CREATED);
 	}

}

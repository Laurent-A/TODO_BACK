package com.laurent.todoapp.main.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laurent.todoapp.main.dao.TodoRepository;
import com.laurent.todoapp.main.dto.TodoDto;
import com.laurent.todoapp.main.exception.ApiNotFoundException;
import com.laurent.todoapp.main.model.Todo;
import com.laurent.todoapp.main.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public TodoServiceImpl() {
		super();
	}
	
	@Autowired
	public TodoServiceImpl(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@Override
	public List<Todo> getAllTodos() {
		return this.todoRepository.findAllByOrderByIdDesc();
	}
	
	@Override
	public Optional<Todo> getTodo(Long id)throws ApiNotFoundException{
		
		Optional<Todo> todoFound = todoRepository.findById(id);
        if (Boolean.FALSE.equals(todoFound.isPresent())){
            throw new ApiNotFoundException("Todo", "id :", id);
        }
		return todoFound;
	}
	
	@Transactional(readOnly=false)
	@Override
	public Todo updateTodo(Long id, TodoDto todoDto)throws ApiNotFoundException {
		Todo todo = this.getTodo(id).orElseThrow(() -> new ApiNotFoundException("Todo", "id", id));
		
		todo.setTitle(todoDto.getTitle());
		todo.setDetail(todoDto.getDetail());
		todo.setState(todoDto.isState());
		try{
		todoRepository.save(todo);
		} catch (ApiNotFoundException e) {
			throw new ApiNotFoundException("Modification impossible", "Erreur : ", e);
 		}
		return todo;
	}

	@Transactional(readOnly=false)
	@Override
	public Todo addTodo(Todo todo)throws ApiNotFoundException {
		try{
			todoRepository.save(todo);
 		} catch (ApiNotFoundException e) {
			throw new ApiNotFoundException("Enregistrement impossible", "Erreur : ", e);
 		}
		return todo;
	}

}

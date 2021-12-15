package com.laurent.todoapp.main.service;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.laurent.todoapp.main.dao.TodoRepository;
import com.laurent.todoapp.main.model.Todo;
import com.laurent.todoapp.main.service.impl.TodoServiceImpl;

class TodoSeviceImplTest {
	
	TodoRepository todoRepository = Mockito.mock(TodoRepository.class);

	@Test
    public void getAllTodos(){

		TodoServiceImpl todoService = new TodoServiceImpl(todoRepository);
 
        Todo todo = new Todo((long) 3, "Visionner la liste",false, "Afficher la liste par ordre decroissant");
    	List<Todo> todos = Arrays.asList(todo);
    	
        Mockito.when(todoRepository.findAllByOrderByIdDesc()).thenReturn(todos);
        List<Todo> result = todoService.getAllTodos();
 
        Assertions.assertThat(result).isNotNull().hasSize(1);
    }

}

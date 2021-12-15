package com.laurent.todoapp.main.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laurent.todoapp.main.model.Todo;
import com.laurent.todoapp.main.service.TodoService;


@WebMvcTest(controllers = TodoController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
class TodoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	private ObjectMapper objectMapper;

	@MockBean
	private TodoService todoService;

	private Todo todo;
	
	@Before
	public void setUp() {
		todo = new Todo((long) 3, "Visionner la liste",false, "Afficher la liste par ordre decroissant");
		List<Todo> allTodos = Arrays.asList(todo);
		objectMapper = new ObjectMapper();

		when(todoService.getAllTodos()).thenReturn(allTodos);

	}

	@Test
	public void testgetAllTodos() throws Exception {

		MvcResult result = mockMvc.perform(get("/todo-app/todos").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isFound()).andReturn();

		verify(todoService).getAllTodos();
		assertNotNull(result);
		List<Todo> todos = objectMapper.readValue(result.getResponse().getContentAsString(),
				new TypeReference<List<Todo>>() {
				});
		assertNotNull(todos);
		assertEquals(1, todos.size());
		Todo todoResult = todos.iterator().next();
		assertEquals(todo.getTitle(), todoResult.getTitle());

	}
}

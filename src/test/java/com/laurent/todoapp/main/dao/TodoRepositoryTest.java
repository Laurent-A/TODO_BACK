package com.laurent.todoapp.main.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.laurent.todoapp.main.model.Todo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;	
	
	@Autowired
    private TodoRepository todoRepository;	
	
	Todo todo = new Todo((long) 3,"TITRE1",true, "LIBELLE");
	
	@Before
	public void setup(){
	    entityManager.persist(todo);
	    entityManager.flush();
	}
	
	@Test
	public void testFindAllTodos() {
	    List<Todo> todos = todoRepository.findAllByOrderByIdDesc();
	    assertThat(2, is(todos.size())); // nombre de todos preenregistré
	}

}

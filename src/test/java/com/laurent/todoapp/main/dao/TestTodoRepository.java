package com.laurent.todoapp.main.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.laurent.todoapp.main.model.Todo;

@RunWith(SpringRunner.class)
@DataJpaTest
class TestTodoRepository {
	
	
	@Autowired
    private TestEntityManager entityManager;	
	
	@Autowired
    private TodoRepository todoRepository;	
	
	Todo todo = new Todo((long) 1,"LAMBDA",true, "Titre");
	
	@Before
	public void setup(){
	    entityManager.persist(todo);//on sauvegarde l'objet user au début de chaque test
	    entityManager.flush();
	}

	@Test
	public void testFindAllTodos() {
	    List<Todo> todos = todoRepository.findAll();
	    assertThat(2, is(todos.size()));
	}

}

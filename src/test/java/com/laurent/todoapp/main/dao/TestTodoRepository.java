package com.laurent.todoapp.main.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import java.util.List;
import java.util.Optional;

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
	
	Todo todo = new Todo((long) 3,"Visionner la liste",true, "Afficher la liste par ordre decroissant");
	
	@Before
	public void setup(){
	    entityManager.persist(todo);
	    entityManager.flush();
	}

	@Test
	public void testFindAllTodos() {
	    List<Todo> todos = todoRepository.findAll();
	    assertThat(2, is(todos.size()));
	}
	
	@Test
	public void testGetTodo() {
		Todo todo = new Todo((long) 1,"Visionner la liste",true, "Titre");
	    Optional<Todo> todoFromDB = todoRepository.findById(todo.getId());	 
	    assertThat(todo.getTitle(), is(todoFromDB.get().getTitle()));  
	}
	
	@Test
    public void testUpdateTodo(){
		Todo todo = new Todo((long) 3,"LAMBDA",true, "Titre");
		Todo todoSaved =  todoRepository.save(todo);
		assertNotNull(todoSaved.getId());
	    assertThat("LAMBDA", is(todoSaved.getTitle()));
	}

}

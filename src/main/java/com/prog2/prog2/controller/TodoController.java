package com.prog2.prog2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prog2.prog2.entity.Persona;
import com.prog2.prog2.entity.Todo;
import com.prog2.prog2.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	TodoService todoService;

	// GET 		http://localhost:8080/todos
	@GetMapping
	public List<Todo> getTodos(){
		return todoService.getTodos();
	}

	// GET 		http://localhost:8080/todos/ ...
	@GetMapping("/{id}")
	public Optional<Todo> getTodoById(@PathVariable ("id") Long id){
		return todoService.getTodosById(id);		
	}

	// POST		http://localhost:8080/todos/
	/*
	 * {
        "text": " ... ",
        "description": " ... ",
        "persona": {
            "id": ...,
            }
    	}
	 */
	@PostMapping
	public void createTodo(@RequestBody Todo todo) {
		todoService.createTodo(todo);
	}

	// DELETE	http://localhost:8080/todos/ ...
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable ("id") Long id) {
		todoService.deleteTodo(id);
	}
	
	// PUT		http://localhost:8080/todos/ ...
	/*
	 * {
        "text": " ... ",
        "description": " ... ",
        "persona": {
            "id": ...,
            }
    	}
	 */
	@PutMapping("/{id}")
	public <U> void updateTodo(@RequestBody Todo todo, @PathVariable Long id) {
		todoService.updateTodo(id, todo);
	}
	
	// GET		http://localhost:8080/todos/userid/ ...
	@GetMapping("/userid/{id}")
	@Query("select * from todo where persona_id = ?1")
	public List<Todo> getTodoByUser(@PathVariable("id") Persona p){
		return todoService.getUserTodos(p);
	}
}
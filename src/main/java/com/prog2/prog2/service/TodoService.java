package com.prog2.prog2.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog2.prog2.entity.Persona;
import com.prog2.prog2.entity.Todo;
import com.prog2.prog2.repository.ITodoRepository;

@Service
public class TodoService {

	@Autowired
	ITodoRepository todoRepo;
	
	public List<Todo> getTodos(){
		return todoRepo.findAll();
	}
	
	public Optional<Todo> getTodosById(Long id){
		return todoRepo.findById(id);
	}
	
	public void createTodo(Todo todo) {
		todoRepo.save(todo);
	}
	
	public void deleteTodo(Long id) {
		todoRepo.deleteById(id);
	}
	
	public <U> void updateTodo(Long id, Todo todo) {
		getTodosById(id).map((Function<? super Todo, ? extends U>) (t -> {
				t.setText(todo.getText());
				t.setDescription(todo.getDescription());
				t.setPersona(todo.getPersona());
				todoRepo.save(t);
				return null;
			  }
		));
	}
	
	
	public List<Todo> getUserTodos(Persona p){
		return todoRepo.findByPersona(p);
	}
}
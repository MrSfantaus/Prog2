package com.prog2.prog2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prog2.prog2.entity.Persona;
import com.prog2.prog2.service.PersonaService;
import com.prog2.prog2.service.TodoService;

@RestController
@RequestMapping("/users")
public class UtentiController {

	@Autowired
	PersonaService personaService;
	
	@Autowired
	TodoService todoService;

	// GET		http://localhost:8080/users
	@GetMapping
	public List<Persona> getUsers(){
		return personaService.getUsers();
	}

	// GET		http://localhost:8080/users/byname/...
	@GetMapping("/byname/{nome}")
	public List<Persona> getUtentiByName(@PathVariable("nome") String nome){
		return personaService.getUserByName(nome);
	}

	// GET		http://localhost:8080/users/byid/...
	@GetMapping("/byid/{id}")
	public Optional<Persona> getUserById(@PathVariable("id") Long id){
		return personaService.getUserById(id);
	}

	// POST		http://localhost:8080/users
	/*	BODY
	 *  {
			        "nome": "....",
			        "cognome": "...."
			    }
	 */
	@PostMapping
	public void createUser(@RequestBody Persona persona) {
		personaService.createUser(persona);
	}

	// DELETE	http://localhost:8080/users/...
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		personaService.deleteUser(id);
	}

	// PUT		http://localhost:8080/users/ ... 
	//												+
													/*	BODY
													 *  {
													        "nome": "....",
													        "cognome": "...."
													    }
													 */
	@PutMapping("/{id}")
	public <U> void updateUser(@RequestBody Persona persona, @PathVariable Long id) {
		personaService.updateUser(id, persona);
	}
	
}
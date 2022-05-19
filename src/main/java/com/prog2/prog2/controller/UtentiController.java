package com.prog2.prog2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prog2.prog2.entity.Persona;
import com.prog2.prog2.service.PersonaService;

@RestController
@RequestMapping("/users")
public class UtentiController {

	@Autowired
	PersonaService personaService;

	// GET		http://localhost:8080/users
	@GetMapping
	public List<Persona> getUsers(){
		return personaService.getUsers();
	}

	// GET		http://localhost:8080/users/byname/...
	@GetMapping("/byname/{nome}")
	public List<Persona> getUtentiByName(@RequestParam String nome){
		return personaService.getUserByName(nome);
	}

	// GET		http://localhost:8080/users/byid/...
	@GetMapping("/byid/{id}")
	public Optional<Persona> getUserById(@PathVariable("id") Long id){
		return personaService.getUserById(id);
	}
}

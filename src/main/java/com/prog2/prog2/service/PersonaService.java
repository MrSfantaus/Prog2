package com.prog2.prog2.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog2.prog2.entity.Persona;
import com.prog2.prog2.repository.IPersonaRepository;

@Service
public class PersonaService {

	@Autowired
	IPersonaRepository personaRepo;
	
	public List<Persona> getUsers(){
		return personaRepo.findAll();
	}

	public Optional<Persona> getUserById(Long id){
		return personaRepo.findById(id);
	}
	
	public List<Persona> getUserByName(String nome) {
		System.out.println(nome);
		return personaRepo.findByNome(nome);
	}
	
	public void createUser(Persona persona) {
		personaRepo.save(persona);
	}
	
	public void deleteUser(Long id) {
		personaRepo.deleteById(id);
	}

	public <U> void updateUser(Long id, Persona persona) {
		getUserById(id).map((Function<? super Persona, ? extends U>) 
			(p -> {
					  p.setNome(persona.getNome());
					  p.setCognome(persona.getCognome());
					  personaRepo.save(p);
					  return null;
				  } 
			));
	}
	
	
}
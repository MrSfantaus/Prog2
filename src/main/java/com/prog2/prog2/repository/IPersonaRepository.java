package com.prog2.prog2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog2.prog2.entity.Persona;

public interface IPersonaRepository extends JpaRepository<Persona, Long> {
	
	Optional<Persona> findById(Long id);
	
	List<Persona> findByNome(String nome);
	
	List<Persona> findByTodosTextLike(String pippo);


}

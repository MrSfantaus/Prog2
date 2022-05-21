package com.prog2.prog2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog2.prog2.entity.Persona;
import com.prog2.prog2.entity.Todo;

public interface ITodoRepository extends JpaRepository<Todo, Long>{

	Optional<Todo> findById(Long id);
	
	List<Todo> findByPersona(Persona p);
}

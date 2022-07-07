package com.bosonit.docker.persona.infraestructure.repository;

import com.bosonit.docker.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {
    List<Persona> findByName(String usuario);
}
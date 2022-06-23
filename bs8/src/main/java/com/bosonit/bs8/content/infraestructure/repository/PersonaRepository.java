package com.bosonit.bs8.content.infraestructure.repository;

import com.bosonit.bs8.content.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    List<Persona> findByName(String usuario);
    void deleteById(int id);
}
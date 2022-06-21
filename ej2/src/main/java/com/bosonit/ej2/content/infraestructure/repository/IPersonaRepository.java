package com.bosonit.ej2.content.infraestructure.repository;

import com.bosonit.ej2.content.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer> {
    List<Persona> findByName(String usuario);
}
package com.bosonit.docker.profesor.infraestructure.repository;

import com.bosonit.docker.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {
}
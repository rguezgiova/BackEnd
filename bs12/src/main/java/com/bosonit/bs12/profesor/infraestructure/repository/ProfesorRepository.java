package com.bosonit.bs12.profesor.infraestructure.repository;

import com.bosonit.bs12.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {
}
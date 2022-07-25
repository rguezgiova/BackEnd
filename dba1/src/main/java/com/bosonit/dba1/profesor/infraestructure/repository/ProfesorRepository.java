package com.bosonit.dba1.profesor.infraestructure.repository;

import com.bosonit.dba1.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {
}
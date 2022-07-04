package com.bosonit.ej3_1.profesor.infraestructure.repository;

import com.bosonit.ej3_1.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {
}
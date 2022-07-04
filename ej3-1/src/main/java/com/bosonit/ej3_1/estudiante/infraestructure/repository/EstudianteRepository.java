package com.bosonit.ej3_1.estudiante.infraestructure.repository;

import com.bosonit.ej3_1.estudiante.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
}
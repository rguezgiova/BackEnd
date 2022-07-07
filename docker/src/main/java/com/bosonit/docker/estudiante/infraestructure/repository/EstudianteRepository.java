package com.bosonit.docker.estudiante.infraestructure.repository;

import com.bosonit.docker.estudiante.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
}
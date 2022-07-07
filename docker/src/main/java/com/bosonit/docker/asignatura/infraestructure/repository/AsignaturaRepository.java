package com.bosonit.docker.asignatura.infraestructure.repository;

import com.bosonit.docker.asignatura.domain.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, String> {
}
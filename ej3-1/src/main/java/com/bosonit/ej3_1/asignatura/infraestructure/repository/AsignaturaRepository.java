package com.bosonit.ej3_1.asignatura.infraestructure.repository;

import com.bosonit.ej3_1.asignatura.domain.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, String> {
}
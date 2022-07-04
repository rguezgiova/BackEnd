package com.bosonit.ej3_1.asignatura.application.port;

import com.bosonit.ej3_1.asignatura.infraestructure.dto.output.AsignaturaOutputDto;
import com.bosonit.ej3_1.profesor.domain.Profesor;

import java.util.List;

public interface GetAsignaturaPort {
    AsignaturaOutputDto getAsignaturaById(String id);
    List<AsignaturaOutputDto> getAsignaturaEstudianteById(String idEstudiante);
}
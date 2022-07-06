package com.bosonit.bs12.asignatura.application.port;

import com.bosonit.bs12.asignatura.infraestructure.dto.output.AsignaturaOutputDto;

import java.util.List;

public interface GetAsignaturaPort {
    AsignaturaOutputDto getAsignaturaById(String id);
    List<AsignaturaOutputDto> getAsignaturaEstudianteById(String idEstudiante);
}
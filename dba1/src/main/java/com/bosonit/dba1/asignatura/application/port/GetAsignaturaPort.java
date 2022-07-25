package com.bosonit.dba1.asignatura.application.port;

import com.bosonit.dba1.asignatura.infraestructure.dto.output.AsignaturaOutputDto;

import java.util.List;

public interface GetAsignaturaPort {
    AsignaturaOutputDto getAsignaturaById(String id);
    List<AsignaturaOutputDto> getAsignaturaEstudianteById(String idEstudiante);
}
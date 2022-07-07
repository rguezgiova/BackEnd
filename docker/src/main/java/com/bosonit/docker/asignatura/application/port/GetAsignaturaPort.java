package com.bosonit.docker.asignatura.application.port;

import com.bosonit.docker.asignatura.infraestructure.dto.output.AsignaturaOutputDto;

import java.util.List;

public interface GetAsignaturaPort {
    AsignaturaOutputDto getAsignaturaById(String id);
    List<AsignaturaOutputDto> getAsignaturaEstudianteById(String idEstudiante);
}
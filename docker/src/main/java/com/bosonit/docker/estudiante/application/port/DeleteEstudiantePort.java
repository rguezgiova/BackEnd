package com.bosonit.docker.estudiante.application.port;

import com.bosonit.docker.estudiante.infraestructure.dto.output.EstudianteOutputDto;

import java.util.List;

public interface DeleteEstudiantePort {
    void deleteEstudiante(String id);
    EstudianteOutputDto deleteAsignaturas(String idEstudiante, List<String> asignaturasDelete);
}
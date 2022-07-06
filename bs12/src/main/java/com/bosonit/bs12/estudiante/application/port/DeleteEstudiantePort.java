package com.bosonit.bs12.estudiante.application.port;

import com.bosonit.bs12.estudiante.infraestructure.dto.output.EstudianteOutputDto;

import java.util.List;

public interface DeleteEstudiantePort {
    void deleteEstudiante(String id);
    EstudianteOutputDto deleteAsignaturas(String idEstudiante, List<String> asignaturasDelete);
}
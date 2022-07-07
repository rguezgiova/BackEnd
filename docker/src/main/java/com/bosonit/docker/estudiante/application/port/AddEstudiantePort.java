package com.bosonit.docker.estudiante.application.port;

import com.bosonit.docker.estudiante.infraestructure.dto.input.EstudianteInputDto;
import com.bosonit.docker.estudiante.infraestructure.dto.output.EstudianteOutputDto;

import java.util.List;

public interface AddEstudiantePort {
    EstudianteOutputDto addEstudiante(EstudianteInputDto estudianteInputDto);
    EstudianteOutputDto addAsignaturas(String idEstudiante, List<String> asignaturasInsert);
}
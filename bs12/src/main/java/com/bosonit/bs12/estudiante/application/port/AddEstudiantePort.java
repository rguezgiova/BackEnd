package com.bosonit.bs12.estudiante.application.port;

import com.bosonit.bs12.estudiante.infraestructure.dto.input.EstudianteInputDto;
import com.bosonit.bs12.estudiante.infraestructure.dto.output.EstudianteOutputDto;

import java.util.List;

public interface AddEstudiantePort {
    EstudianteOutputDto addEstudiante(EstudianteInputDto estudianteInputDto);
    EstudianteOutputDto addAsignaturas(String idEstudiante, List<String> asignaturasInsert);
}
package com.bosonit.ej3_1.estudiante.application.port;

import com.bosonit.ej3_1.estudiante.infraestructure.dto.input.EstudianteInputDto;
import com.bosonit.ej3_1.estudiante.infraestructure.dto.output.EstudianteOutputDto;

import java.util.List;

public interface AddEstudiantePort {
    EstudianteOutputDto addEstudiante(EstudianteInputDto estudianteInputDto);
    EstudianteOutputDto addAsignaturas(String idEstudiante, List<String> asignaturasInsert);
}
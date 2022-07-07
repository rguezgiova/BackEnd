package com.bosonit.docker.estudiante.application.port;

import com.bosonit.docker.estudiante.domain.Estudiante;
import com.bosonit.docker.estudiante.infraestructure.dto.input.EstudianteInputDto;
import com.bosonit.docker.estudiante.infraestructure.dto.output.EstudianteOutputDto;

public interface UpdateEstudiantePort {
    Estudiante getEstudianteId(String id);

    EstudianteOutputDto updateEstudiante(String id, EstudianteInputDto estudianteInputDto);
}
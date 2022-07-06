package com.bosonit.bs12.estudiante.application.port;

import com.bosonit.bs12.estudiante.domain.Estudiante;
import com.bosonit.bs12.estudiante.infraestructure.dto.input.EstudianteInputDto;
import com.bosonit.bs12.estudiante.infraestructure.dto.output.EstudianteOutputDto;

public interface UpdateEstudiantePort {
    Estudiante getEstudianteId(String id);

    EstudianteOutputDto updateEstudiante(String id, EstudianteInputDto estudianteInputDto);
}
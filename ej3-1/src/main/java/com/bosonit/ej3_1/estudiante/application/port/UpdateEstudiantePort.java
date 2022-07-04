package com.bosonit.ej3_1.estudiante.application.port;

import com.bosonit.ej3_1.estudiante.domain.Estudiante;
import com.bosonit.ej3_1.estudiante.infraestructure.dto.input.EstudianteInputDto;
import com.bosonit.ej3_1.estudiante.infraestructure.dto.output.EstudianteOutputDto;

public interface UpdateEstudiantePort {
    Estudiante getEstudianteId(String id);

    EstudianteOutputDto updateEstudiante(String id, EstudianteInputDto estudianteInputDto);
}
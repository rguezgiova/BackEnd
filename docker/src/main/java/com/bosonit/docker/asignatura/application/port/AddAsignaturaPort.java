package com.bosonit.docker.asignatura.application.port;

import com.bosonit.docker.asignatura.infraestructure.dto.input.AsignaturaInputDto;
import com.bosonit.docker.asignatura.infraestructure.dto.output.AsignaturaOutputDto;

public interface AddAsignaturaPort {
    AsignaturaOutputDto addAsignatura(AsignaturaInputDto estudioInputDto);
}
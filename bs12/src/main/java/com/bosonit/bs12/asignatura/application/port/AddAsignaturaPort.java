package com.bosonit.bs12.asignatura.application.port;

import com.bosonit.bs12.asignatura.infraestructure.dto.input.AsignaturaInputDto;
import com.bosonit.bs12.asignatura.infraestructure.dto.output.AsignaturaOutputDto;

public interface AddAsignaturaPort {
    AsignaturaOutputDto addAsignatura(AsignaturaInputDto estudioInputDto);
}
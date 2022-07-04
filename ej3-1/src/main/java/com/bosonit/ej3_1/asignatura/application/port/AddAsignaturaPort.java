package com.bosonit.ej3_1.asignatura.application.port;

import com.bosonit.ej3_1.asignatura.infraestructure.dto.input.AsignaturaInputDto;
import com.bosonit.ej3_1.asignatura.infraestructure.dto.output.AsignaturaOutputDto;

public interface AddAsignaturaPort {
    AsignaturaOutputDto addAsignatura(AsignaturaInputDto estudioInputDto);
}
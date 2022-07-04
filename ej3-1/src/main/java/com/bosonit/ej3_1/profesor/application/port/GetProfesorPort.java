package com.bosonit.ej3_1.profesor.application.port;

import com.bosonit.ej3_1.profesor.domain.Profesor;
import com.bosonit.ej3_1.profesor.infraestructure.dto.output.ProfesorOutputDto;

public interface GetProfesorPort {
    ProfesorOutputDto getProfesorId(String id);
}
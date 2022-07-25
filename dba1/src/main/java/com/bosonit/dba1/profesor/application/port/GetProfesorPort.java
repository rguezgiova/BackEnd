package com.bosonit.dba1.profesor.application.port;

import com.bosonit.dba1.profesor.infraestructure.dto.output.ProfesorOutputDto;

public interface GetProfesorPort {
    ProfesorOutputDto getProfesorId(String id);
}
package com.bosonit.bs12.profesor.application.port;

import com.bosonit.bs12.profesor.infraestructure.dto.output.ProfesorOutputDto;

public interface GetProfesorPort {
    ProfesorOutputDto getProfesorId(String id);
}
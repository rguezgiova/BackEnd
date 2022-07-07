package com.bosonit.docker.profesor.application.port;

import com.bosonit.docker.profesor.infraestructure.dto.output.ProfesorOutputDto;

public interface GetProfesorPort {
    ProfesorOutputDto getProfesorId(String id);
}
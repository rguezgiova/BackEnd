package com.bosonit.docker.profesor.application.port;

import com.bosonit.docker.profesor.infraestructure.dto.input.ProfesorInputDto;
import com.bosonit.docker.profesor.infraestructure.dto.output.ProfesorOutputDto;

public interface UpdateProfesorPort {
    ProfesorOutputDto updateProfesor(String id, ProfesorInputDto profesorInputDto);
}
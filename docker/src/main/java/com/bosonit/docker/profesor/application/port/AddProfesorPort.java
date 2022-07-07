package com.bosonit.docker.profesor.application.port;

import com.bosonit.docker.profesor.infraestructure.dto.input.ProfesorInputDto;
import com.bosonit.docker.profesor.infraestructure.dto.output.ProfesorOutputDto;

public interface AddProfesorPort {
    ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto);
}
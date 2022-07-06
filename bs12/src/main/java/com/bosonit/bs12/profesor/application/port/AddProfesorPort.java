package com.bosonit.bs12.profesor.application.port;

import com.bosonit.bs12.profesor.infraestructure.dto.input.ProfesorInputDto;
import com.bosonit.bs12.profesor.infraestructure.dto.output.ProfesorOutputDto;

public interface AddProfesorPort {
    ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto);
}
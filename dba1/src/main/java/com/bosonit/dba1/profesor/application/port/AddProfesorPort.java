package com.bosonit.dba1.profesor.application.port;

import com.bosonit.dba1.profesor.infraestructure.dto.input.ProfesorInputDto;
import com.bosonit.dba1.profesor.infraestructure.dto.output.ProfesorOutputDto;

public interface AddProfesorPort {
    ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto);
}
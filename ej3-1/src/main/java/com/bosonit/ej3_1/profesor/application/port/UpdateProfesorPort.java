package com.bosonit.ej3_1.profesor.application.port;

import com.bosonit.ej3_1.profesor.infraestructure.dto.input.ProfesorInputDto;
import com.bosonit.ej3_1.profesor.infraestructure.dto.output.ProfesorOutputDto;

public interface UpdateProfesorPort {
    ProfesorOutputDto updateProfesor(String id, ProfesorInputDto profesorInputDto);
}
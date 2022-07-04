package com.bosonit.ej3_1.persona.application.port;

import com.bosonit.ej3_1.persona.infraestructure.dto.output.PersonaOutputDto;

import java.util.List;

public interface GetPersonaPort {
    PersonaOutputDto getPersonaId(String id);
    List<PersonaOutputDto> getPersonaName(String usuario);
    List<PersonaOutputDto> getPersonas();
}
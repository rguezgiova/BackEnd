package com.bosonit.bs12.persona.application.port;

import com.bosonit.bs12.persona.infraestructure.dto.output.PersonaOutputDto;

import java.util.List;

public interface GetPersonaPort {
    PersonaOutputDto getPersonaId(String id);
    List<PersonaOutputDto> getPersonaName(String usuario);
    List<PersonaOutputDto> getPersonas();
}
package com.bosonit.docker.persona.application.port;

import com.bosonit.docker.persona.infraestructure.dto.output.PersonaOutputDto;

import java.util.List;

public interface GetPersonaPort {
    PersonaOutputDto getPersonaId(String id);
    List<PersonaOutputDto> getPersonaName(String usuario);
    List<PersonaOutputDto> getPersonas();
}
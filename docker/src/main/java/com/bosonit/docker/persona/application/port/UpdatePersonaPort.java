package com.bosonit.docker.persona.application.port;

import com.bosonit.docker.persona.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.docker.persona.infraestructure.dto.output.PersonaOutputDto;

public interface UpdatePersonaPort {
    PersonaOutputDto updatePersona(String id, PersonaInputDto personaInputDto);
}
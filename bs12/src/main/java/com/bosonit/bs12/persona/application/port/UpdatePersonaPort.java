package com.bosonit.bs12.persona.application.port;

import com.bosonit.bs12.persona.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.bs12.persona.infraestructure.dto.output.PersonaOutputDto;

public interface UpdatePersonaPort {
    PersonaOutputDto updatePersona(String id, PersonaInputDto personaInputDto);
}
package com.bosonit.bs8.content.application.port;

import com.bosonit.bs8.content.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.bs8.content.infraestructure.dto.output.PersonaOutputDto;

public interface AddPersonaPort {
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto);
}
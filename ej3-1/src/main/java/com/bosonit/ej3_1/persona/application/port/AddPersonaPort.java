package com.bosonit.ej3_1.persona.application.port;

import com.bosonit.ej3_1.persona.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.ej3_1.persona.infraestructure.dto.output.PersonaOutputDto;

public interface AddPersonaPort {
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto);
}
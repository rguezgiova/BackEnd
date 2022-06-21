package com.bosonit.bp1.content.application.port;

import com.bosonit.bp1.content.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.bp1.content.infraestructure.dto.output.PersonaOutputDto;

public interface UpdatePersonaPort {
    PersonaOutputDto updatePersona(int id, PersonaInputDto personaInputDto) throws Exception;
}
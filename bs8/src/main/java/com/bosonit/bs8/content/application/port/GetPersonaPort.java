package com.bosonit.bs8.content.application.port;

import com.bosonit.bs8.content.infraestructure.dto.output.PersonaOutputDto;

import java.util.List;

public interface GetPersonaPort {
    PersonaOutputDto getPersonaId(int id);
    List<PersonaOutputDto> getPersonaName(String usuario);
    List<PersonaOutputDto> getPersonas();
}
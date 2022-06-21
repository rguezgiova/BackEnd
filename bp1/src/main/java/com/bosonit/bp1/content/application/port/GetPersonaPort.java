package com.bosonit.bp1.content.application.port;

import com.bosonit.bp1.content.infraestructure.dto.output.PersonaOutputDto;

import java.util.List;

public interface GetPersonaPort {
    PersonaOutputDto getPersonaId(int id) throws Exception;
    List<PersonaOutputDto> getPersonaName(String usuario) throws Exception;
    List<PersonaOutputDto> getPersonas();
}
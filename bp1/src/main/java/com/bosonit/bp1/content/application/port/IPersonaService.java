package com.bosonit.bp1.content.application.port;

import com.bosonit.bp1.content.infraestructure.controller.dto.input.PersonaInputDto;
import com.bosonit.bp1.content.infraestructure.controller.dto.output.PersonaOutputDto;

import java.util.List;

public interface IPersonaService {
    PersonaOutputDto addPersona(PersonaInputDto personaInputDto) throws Exception;
    PersonaOutputDto getPersonaId(int id) throws Exception;
    List<PersonaOutputDto> getPersonaName(String usuario) throws Exception;
    List<PersonaOutputDto> getPersonas();
    PersonaOutputDto updatePersona(int id, PersonaInputDto personaInputDto) throws Exception;
    void deletePersona(int id) throws Exception;
}
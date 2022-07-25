package com.bosonit.dba1.persona.application.port;

import com.bosonit.dba1.persona.domain.Persona;
import com.bosonit.dba1.persona.infraestructure.dto.output.PersonaOutputDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GetPersonaPort {
    PersonaOutputDto getPersonaId(String id);
    List<PersonaOutputDto> getPersonaName(String usuario);
    List<PersonaOutputDto> getPersonas();
    Page<Persona> getPersonasPageable(Pageable pageable);
}
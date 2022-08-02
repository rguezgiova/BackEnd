package com.bosonit.te1.application.port;

import com.bosonit.te1.persona.domain.Persona;
import com.bosonit.te1.persona.infraestructure.dto.PersonaDto;

import java.util.List;

public interface PersonaService {
    Persona addPersona(PersonaDto personaDto);
    void deletePersona(Integer id);
    List<Persona> getPersonaName(String nombre);
    List<Persona> getPersonas();
    Persona updatePersona(Integer id, Persona persona);
}
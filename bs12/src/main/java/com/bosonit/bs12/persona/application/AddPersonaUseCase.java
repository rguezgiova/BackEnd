package com.bosonit.bs12.persona.application;

import com.bosonit.bs12.persona.application.port.AddPersonaPort;
import com.bosonit.bs12.persona.domain.Persona;
import com.bosonit.bs12.persona.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.bs12.persona.infraestructure.dto.output.PersonaOutputDto;
import com.bosonit.bs12.persona.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddPersonaUseCase implements AddPersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto) {
        Persona persona = new Persona(personaInputDto);
        personaRepository.save(persona);
        return new PersonaOutputDto(persona);
    }
}
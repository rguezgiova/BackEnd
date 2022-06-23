package com.bosonit.bs8.content.application;

import com.bosonit.bs8.content.application.port.AddPersonaPort;
import com.bosonit.bs8.content.domain.Persona;
import com.bosonit.bs8.content.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.bs8.content.infraestructure.dto.output.PersonaOutputDto;
import com.bosonit.bs8.content.infraestructure.repository.PersonaRepository;
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
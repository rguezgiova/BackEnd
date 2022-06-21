package com.bosonit.bp1.content.application;

import com.bosonit.bp1.content.application.port.AddPersonaPort;
import com.bosonit.bp1.content.domain.Persona;
import com.bosonit.bp1.content.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.bp1.content.infraestructure.dto.output.PersonaOutputDto;
import com.bosonit.bp1.content.infraestructure.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddPersonaUseCase implements AddPersonaPort {
    @Autowired
    IPersonaRepository personaRepository;

    @Override
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto) throws Exception {
        Persona persona = new Persona(personaInputDto);
        personaRepository.save(persona);
        return new PersonaOutputDto(persona);
    }
}
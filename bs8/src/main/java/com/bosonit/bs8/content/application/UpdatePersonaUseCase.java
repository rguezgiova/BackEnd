package com.bosonit.bs8.content.application;

import com.bosonit.bs8.content.application.port.UpdatePersonaPort;
import com.bosonit.bs8.content.domain.Persona;
import com.bosonit.bs8.content.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.bs8.content.infraestructure.dto.output.PersonaOutputDto;
import com.bosonit.bs8.content.infraestructure.repository.PersonaRepository;
import com.bosonit.bs8.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonaUseCase implements UpdatePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto updatePersona(int id, PersonaInputDto personaInputDto) throws NotFoundException {
        Persona personaEncontrada = personaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún usuario con dicha ID"));
        personaEncontrada.update(personaInputDto);
        personaRepository.save(personaEncontrada);
        return new PersonaOutputDto(personaEncontrada);
    }
}
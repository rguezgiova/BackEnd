package com.bosonit.bp1.content.application;

import com.bosonit.bp1.content.application.port.UpdatePersonaPort;
import com.bosonit.bp1.content.domain.Persona;
import com.bosonit.bp1.content.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.bp1.content.infraestructure.dto.output.PersonaOutputDto;
import com.bosonit.bp1.content.infraestructure.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdatePersonaUseCase implements UpdatePersonaPort {
    @Autowired
    IPersonaRepository personaRepository;

    @Override
    public PersonaOutputDto updatePersona(int id, PersonaInputDto personaInputDto) throws Exception {
        Persona personaEncontrada = personaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "No se ha encontrado usuario con dicha ID"));
        personaEncontrada.update(personaInputDto);
        personaRepository.save(personaEncontrada);
        return new PersonaOutputDto(personaEncontrada);
    }
}
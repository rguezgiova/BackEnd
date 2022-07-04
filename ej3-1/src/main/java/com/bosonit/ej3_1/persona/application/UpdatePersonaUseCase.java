package com.bosonit.ej3_1.persona.application;

import com.bosonit.ej3_1.persona.application.port.UpdatePersonaPort;
import com.bosonit.ej3_1.persona.domain.Persona;
import com.bosonit.ej3_1.persona.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.ej3_1.persona.infraestructure.dto.output.PersonaOutputDto;
import com.bosonit.ej3_1.persona.infraestructure.repository.PersonaRepository;
import com.bosonit.ej3_1.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonaUseCase implements UpdatePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto updatePersona(String id, PersonaInputDto personaInputDto) throws NotFoundException {
        Persona personaEncontrada = personaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún usuario con dicha ID"));
        personaEncontrada.update(personaInputDto);
        personaRepository.save(personaEncontrada);
        return new PersonaOutputDto(personaEncontrada);
    }
}
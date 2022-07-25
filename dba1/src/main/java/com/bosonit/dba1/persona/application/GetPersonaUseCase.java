package com.bosonit.dba1.persona.application;

import com.bosonit.dba1.persona.application.port.GetPersonaPort;
import com.bosonit.dba1.persona.domain.Persona;
import com.bosonit.dba1.persona.infraestructure.dto.output.PersonaOutputDto;
import com.bosonit.dba1.persona.infraestructure.repository.PersonaRepository;
import com.bosonit.dba1.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetPersonaUseCase implements GetPersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto getPersonaId(String id) throws NotFoundException {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún usuario con dicha ID"));
        return new PersonaOutputDto(persona);
    }

    @Override
    public List<PersonaOutputDto> getPersonaName(String usuario) {
        List<PersonaOutputDto> tempList = new ArrayList<>();
        personaRepository.findByName(usuario).forEach(persona ->  {
            tempList.add(new PersonaOutputDto(persona));
        });
        return tempList;
    }

    @Override
    public List<PersonaOutputDto> getPersonas() {
        List<PersonaOutputDto> tempList = new ArrayList<>();
        personaRepository.findAll().forEach(persona -> {
            PersonaOutputDto personaOutputDto = new PersonaOutputDto(persona);
            tempList.add(personaOutputDto);
        });
        return tempList;
    }

    @Override
    public Page<Persona> getPersonasPageable(Pageable pageable) {
        return personaRepository.findAll(pageable);
    }
}
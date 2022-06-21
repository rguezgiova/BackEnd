package com.bosonit.bp1.content.application;

import com.bosonit.bp1.content.application.port.GetPersonaPort;
import com.bosonit.bp1.content.domain.Persona;
import com.bosonit.bp1.content.infraestructure.dto.output.PersonaOutputDto;
import com.bosonit.bp1.content.infraestructure.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetPersonaUseCase implements GetPersonaPort {
    @Autowired
    IPersonaRepository personaRepository;

    @Override
    public PersonaOutputDto getPersonaId(int id) throws Exception {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe usuario con dicha ID"));
        return new PersonaOutputDto(persona);
    }

    @Override
    public List<PersonaOutputDto> getPersonaName(String usuario) throws Exception {
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
}
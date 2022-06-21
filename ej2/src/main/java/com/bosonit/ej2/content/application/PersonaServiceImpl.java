package com.bosonit.ej2.content.application;

import com.bosonit.ej2.content.application.port.IPersonaService;
import com.bosonit.ej2.content.domain.Persona;
import com.bosonit.ej2.content.infraestructure.controller.dto.input.PersonaInputDto;
import com.bosonit.ej2.content.infraestructure.controller.dto.output.PersonaOutputDto;
import com.bosonit.ej2.content.infraestructure.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    IPersonaRepository personaRepository;

    @Override
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto) throws Exception {
        Persona persona = new Persona(personaInputDto);
        personaRepository.save(persona);
        return new PersonaOutputDto(persona);
    }

    @Override
    public PersonaOutputDto getPersonaId(int id) throws Exception {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new Exception("No existe ningún usuario con dicha ID"));
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
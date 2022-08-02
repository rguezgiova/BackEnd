package com.bosonit.te1.application;

import com.bosonit.te1.application.port.PersonaService;
import com.bosonit.te1.persona.domain.Persona;
import com.bosonit.te1.persona.infraestructure.dto.PersonaDto;
import com.bosonit.te1.persona.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Persona addPersona(PersonaDto personaDto) {
        return personaRepository.save(new Persona(personaDto));
    }

    @Override
    public List<Persona> getPersonaName(String name) {
        return personaRepository.findByName(name);
    }

    @Override
    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public void deletePersona(Integer id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona updatePersona(Integer id, Persona persona) {
        Persona personaEncontrada = personaRepository.findById(id).orElseThrow();
        if (persona.getUsername() != null) {
            personaEncontrada.setUsername(persona.getUsername());
        }
        if (persona.getPassword() != null) {
            personaEncontrada.setPassword(persona.getPassword());
        }
        if (persona.getName() != null) {
            personaEncontrada.setName(persona.getName());
        }
        if (persona.getSurname() != null) {
            personaEncontrada.setSurname(persona.getSurname());
        }
        return personaRepository.save(personaEncontrada);
    }
}
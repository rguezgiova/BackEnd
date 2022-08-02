package com.bosonit.te1.persona.infraestructure.controller;

import com.bosonit.te1.application.port.PersonaService;
import com.bosonit.te1.persona.domain.Persona;
import com.bosonit.te1.persona.infraestructure.dto.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/persona")
@RestController
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @PostMapping
    public PersonaDto addPersona(@RequestBody PersonaDto personaDto) {
        return new PersonaDto(personaService.addPersona(personaDto));
    }

    @GetMapping("/name/{name}")
    public List<PersonaDto> getPersonaName(@PathVariable("name") String name) {
        return personaService.getPersonaName(name).stream().map(PersonaDto::new).toList();
    }

    @GetMapping("/getall")
    public List<PersonaDto> getAll() {
        return personaService.getPersonas().stream().map(PersonaDto::new).toList();
    }

    @PutMapping("{id}")
    public PersonaDto updatePersona(@PathVariable("id") Integer id, @RequestBody PersonaDto personaDto) {
        return new PersonaDto(personaService.updatePersona(id, new Persona(personaDto)));
    }

    @DeleteMapping("{id}")
    public void deletePersona(@PathVariable("id") Integer id) {
        personaService.deletePersona(id);
    }
}
package com.bosonit.dba2.persona.infraestructure.controller;

import com.bosonit.dba2.persona.domain.Persona;
import com.bosonit.dba2.persona.infraestructure.dto.PersonaDto;
import com.bosonit.dba2.persona.infraestructure.template.PersonaDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/persona")
@RestController
public class PersonaController {
    @Autowired
    PersonaDal personaDal;

    @PostMapping
    public PersonaDto addPersona(@RequestBody PersonaDto personaDto) {
        return new PersonaDto(personaDal.addPersona(new Persona(personaDto)));
    }

    @GetMapping("/{id}")
    public Persona getPersonaId(@PathVariable("id") String id) {
        return personaDal.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<PersonaDto> getPersonaName(@PathVariable("name") String name) {
        return personaDal.findByName(name).stream().map(PersonaDto::new).collect(Collectors.toList());
    }

    @GetMapping("/getall")
    public List<PersonaDto> getAll() {
        return personaDal.getAll().stream().map(PersonaDto::new).collect(Collectors.toList());
    }

    @PutMapping("{id}")
    public PersonaDto updatePersona(@PathVariable("id") String id, @RequestBody PersonaDto personaDto) {
        return new PersonaDto(personaDal.updatePersona(id, new Persona(personaDto)));
    }

    @DeleteMapping
    public void deletePersona(@RequestBody PersonaDto personaDto) {
        personaDal.deletePersona(new Persona(personaDto));
    }
}
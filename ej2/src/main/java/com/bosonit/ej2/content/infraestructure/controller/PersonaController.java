package com.bosonit.ej2.content.infraestructure.controller;

import com.bosonit.ej2.content.application.port.IPersonaService;
import com.bosonit.ej2.content.infraestructure.controller.dto.input.PersonaInputDto;
import com.bosonit.ej2.content.infraestructure.controller.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/persona")
@RestController
public class PersonaController {
    @Autowired
    IPersonaService personaService;

    @PostMapping("/add")
    public PersonaOutputDto addPersona(@RequestBody PersonaInputDto personaInputDto) throws Exception {
        return personaService.addPersona(personaInputDto);
    }

    @GetMapping("/id/{id}")
    public PersonaOutputDto getPersonaId(@PathVariable("id") int id) throws Exception {
        return personaService.getPersonaId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaOutputDto> getPersonaName(@PathVariable("nombre") String usuario) throws Exception {
        return personaService.getPersonaName(usuario);
    }

    @GetMapping
    public List<PersonaOutputDto> getPersonas() {
        return personaService.getPersonas();
    }
}
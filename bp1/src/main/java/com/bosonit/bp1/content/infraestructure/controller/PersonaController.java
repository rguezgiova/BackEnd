package com.bosonit.bp1.content.infraestructure.controller;

import com.bosonit.bp1.content.application.port.AddPersonaPort;
import com.bosonit.bp1.content.application.port.DeletePersonaPort;
import com.bosonit.bp1.content.application.port.GetPersonaPort;
import com.bosonit.bp1.content.application.port.UpdatePersonaPort;
import com.bosonit.bp1.content.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.bp1.content.infraestructure.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/persona")
@RestController
public class PersonaController {
    @Autowired
    AddPersonaPort addPersonaPort;
    @Autowired
    DeletePersonaPort deletePersonaPort;
    @Autowired
    GetPersonaPort getPersonaPort;
    @Autowired
    UpdatePersonaPort updatePersonaPort;

    @PostMapping
    public PersonaOutputDto addPersona(@RequestBody PersonaInputDto personaInputDto) throws Exception {
        return addPersonaPort.addPersona(personaInputDto);
    }

    @GetMapping("/{id}")
    public PersonaOutputDto getPersonaId(@PathVariable("id") int id) throws Exception {
        return getPersonaPort.getPersonaId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaOutputDto> getPersonaName(@PathVariable("nombre") String usuario) throws Exception {
        return getPersonaPort.getPersonaName(usuario);
    }

    @GetMapping
    public List<PersonaOutputDto> getPersonas() {
        return getPersonaPort.getPersonas();
    }

    @PutMapping("/{id}")
    public PersonaOutputDto updatePersona(@PathVariable("id") int id, @RequestBody PersonaInputDto personaInputDto) throws Exception {
        return updatePersonaPort.updatePersona(id, personaInputDto);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable("id") int id) throws Exception {
        deletePersonaPort.deletePersona(id);
    }
}
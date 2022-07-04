package com.bosonit.ej3_1.persona.infraestructure.controller;

import com.bosonit.ej3_1.persona.application.port.AddPersonaPort;
import com.bosonit.ej3_1.persona.application.port.DeletePersonaPort;
import com.bosonit.ej3_1.persona.application.port.GetPersonaPort;
import com.bosonit.ej3_1.persona.application.port.UpdatePersonaPort;
import com.bosonit.ej3_1.persona.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.ej3_1.persona.infraestructure.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public PersonaOutputDto addPersona(@Valid @RequestBody PersonaInputDto personaInputDto) {
        return addPersonaPort.addPersona(personaInputDto);
    }

    @GetMapping("/{id}")
    public PersonaOutputDto getPersonaId(@PathVariable("id") String id) {
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
    public PersonaOutputDto updatePersona(@PathVariable("id") String id, @Valid @RequestBody PersonaInputDto personaInputDto) {
        return updatePersonaPort.updatePersona(id, personaInputDto);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable("id") String id) {
        deletePersonaPort.deletePersona(id);
    }
}
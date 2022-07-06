package com.bosonit.bs12.persona.infraestructure.controller;

import com.bosonit.bs12.feign.IFeignServer;
import com.bosonit.bs12.persona.application.port.AddPersonaPort;
import com.bosonit.bs12.persona.application.port.DeletePersonaPort;
import com.bosonit.bs12.persona.application.port.GetPersonaPort;
import com.bosonit.bs12.persona.application.port.UpdatePersonaPort;
import com.bosonit.bs12.persona.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.bs12.persona.infraestructure.dto.output.PersonaOutputDto;
import com.bosonit.bs12.profesor.infraestructure.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @Autowired
    IFeignServer feignServer;

    @CrossOrigin(origins = "*")
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

    @CrossOrigin(origins = "*")
    @GetMapping("/getall")
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

    @GetMapping("/persona/profesor/{id}")
    public ProfesorOutputDto getProfesor(@PathVariable("id") String idProfesor) {
        return feignServer.getProfesor(idProfesor);
    }
}
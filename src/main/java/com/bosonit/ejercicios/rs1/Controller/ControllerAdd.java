package com.bosonit.ejercicios.rs1.Controller;

import com.bosonit.ejercicios.rs1.Class.IPersonaService;
import com.bosonit.ejercicios.rs1.Class.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class ControllerAdd {
    @Autowired
    IPersonaService iPersonaService;

    @PostMapping
    public Persona addPersona(@RequestBody Persona persona) {
        iPersonaService.addPersona(persona);
        return persona;
    }
}
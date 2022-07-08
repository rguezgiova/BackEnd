package com.bosonit.jva2.controller;

import com.bosonit.jva2.Jva2Application;
import com.bosonit.jva2.classes.Ciudad;
import com.bosonit.jva2.classes.Persona;
import com.bosonit.jva2.classes.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ControllerSet {
    @Autowired
    PersonaService personaService;

    @GetMapping("/persona/addPersona")
    public Persona addPersona(@RequestHeader Map<String, String> header) {
        Persona persona = new Persona(
            header.get("nombre"),
            Integer.parseInt(header.get("edad")),
            header.get("poblacion")
        );
        personaService.addPersona(persona);
        return persona;
    }

    @PostMapping("/ciudad/addCiudad")
    public Ciudad addCiudad(@RequestBody Ciudad ciudad) {
        List<Ciudad> ciudadList = (List<Ciudad>) Jva2Application.configurableApplicationContext.getBean("listaCiudades");
        ciudadList.add(ciudad);
        return ciudad;
    }
}
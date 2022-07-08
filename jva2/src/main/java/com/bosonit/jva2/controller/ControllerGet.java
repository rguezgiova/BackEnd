package com.bosonit.jva2.controller;

import com.bosonit.jva2.Jva2Application;
import com.bosonit.jva2.classes.Ciudad;
import com.bosonit.jva2.classes.Persona;
import com.bosonit.jva2.classes.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerGet {
    @Autowired
    PersonaService personaService;

    @GetMapping("/persona/getPersona")
    public Persona getPersona() {
        return new Persona(
            personaService.getPersona().nombre(),
            personaService.getPersona().edad() * 2,
            personaService.getPersona().poblacion()
        );
    }

    @GetMapping("/ciudad/getCiudad")
    public List<Ciudad> getCiudad() {
        return (List<Ciudad>) Jva2Application.configurableApplicationContext.getBean("listaCiudades");
    }
}
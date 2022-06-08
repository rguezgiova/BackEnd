package com.bosonit.ejercicios.bs2.Controller;

import com.bosonit.ejercicios.bs2.Application.RunApplication;
import com.bosonit.ejercicios.bs2.Class.Ciudad;
import com.bosonit.ejercicios.bs2.Class.Persona;
import com.bosonit.ejercicios.bs2.Class.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller2 {
    @Autowired
    PersonaService personaService;

    @GetMapping("/controlador2/getPersona")
    public Persona getPersona() {
        Persona newPersona = personaService.getPersona();
        newPersona.setEdad(newPersona.getEdad() * 2);
        return personaService.getPersona();
    }

    @GetMapping("/controlador2/getCiudad")
    public List<Ciudad> getCiudad() {
        return (List<Ciudad>) RunApplication.configurableApplicationContext.getBean("listaCiudades");
    }
}

package com.bosonit.ejercicios.bs2.Controller;

import com.bosonit.ejercicios.bs2.Application.BS2Application;
import com.bosonit.ejercicios.bs2.Class.Ciudad;
import com.bosonit.ejercicios.bs2.Class.Persona;
import com.bosonit.ejercicios.bs2.Class.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Controller1 {
    @Autowired
    PersonaService personaService;

    @GetMapping("/controlador1/addPersona")
    public Persona addPersona(@RequestHeader Map<String, String> header) {
        Persona newPersona = Persona.builder()
                                  .nombre(header.get("nombre"))
                                  .edad(Integer.parseInt(header.get("edad")))
                                  .poblacion(header.get("poblacion"))
                                  .build();
        personaService.setPersona(newPersona);
        return newPersona;
    }

    @PostMapping("/controlador1/addCiudad")
    public Ciudad addCiudad(@RequestBody Ciudad ciudad) {
        List<Ciudad> beanList = (List<Ciudad>) BS2Application.configurableApplicationContext.getBean("listaCiudades");
        beanList.add(ciudad);
        return ciudad;
    }
}
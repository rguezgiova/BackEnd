package com.bosonit.ejercicios.bs0.Controller;

import com.bosonit.ejercicios.bs0.Class.Persona;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {
    @GetMapping("/user/{nombre}")
    public String saludo(@PathVariable("nombre") String nombre) {
        return "Hola " + nombre;
    }

    @PostMapping("/useradd")
    public Persona userAdd(@RequestBody Persona persona) {
        int edad = persona.getEdad();
        persona.setEdad(edad + 1);
        return persona;
    }
}
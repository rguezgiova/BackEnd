package com.bosonit.ejercicios.rs1.Controller;

import com.bosonit.ejercicios.rs1.Class.IPersonaService;
import com.bosonit.ejercicios.rs1.Class.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class ControllerUpdate {
    @Autowired
    IPersonaService iPersonaService;

    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable("id") int id, @RequestBody Persona persona) {
        Persona personaEncontrada = iPersonaService.buscarPersona(id);
        Optional<Persona> personaOptional = Optional.of(persona);
        personaEncontrada.setNombre(personaOptional.map(Persona::getNombre).orElse(personaEncontrada.getNombre()));
        personaEncontrada.setEdad(personaOptional.map(Persona::getEdad).orElse(personaEncontrada.getEdad()));
        personaEncontrada.setPoblacion(personaOptional.map(Persona::getPoblacion).orElse(personaEncontrada.getPoblacion()));
        return personaEncontrada;
    }
}
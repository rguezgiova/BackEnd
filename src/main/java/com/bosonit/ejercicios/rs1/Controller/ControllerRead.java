package com.bosonit.ejercicios.rs1.Controller;

import com.bosonit.ejercicios.rs1.Class.IPersonaService;
import com.bosonit.ejercicios.rs1.Class.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class ControllerRead {
    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("/nombre/{nombre}")
    public Persona buscarPersonaNombre(@PathVariable("nombre") String nombre) {
        return iPersonaService.buscarPersona(nombre);
    }

    @GetMapping("/{id}")
    public Persona buscarPersonaId(@PathVariable("id") int id) {
        return iPersonaService.buscarPersona(id);
    }
}
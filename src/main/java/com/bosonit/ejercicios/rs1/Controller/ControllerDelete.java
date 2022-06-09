package com.bosonit.ejercicios.rs1.Controller;

import com.bosonit.ejercicios.rs1.Class.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class ControllerDelete {
    @Autowired
    IPersonaService iPersonaService;

    @DeleteMapping("/{id}")
    public String deletePersona(@PathVariable("id") int id) {
        if (iPersonaService.eliminarPersona(id)) {
            return "La persona con ID " + id + " ha sido eliminada correctamente";
        } else {
            return "No se ha podido eliminar a la persona con ID " + id;
        }
    }
}
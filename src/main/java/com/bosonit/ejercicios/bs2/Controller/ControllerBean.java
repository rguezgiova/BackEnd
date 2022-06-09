package com.bosonit.ejercicios.bs2.Controller;

import com.bosonit.ejercicios.bs2.Application.BS2Application;
import com.bosonit.ejercicios.bs2.Class.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBean {
    @GetMapping("/controlador/bean/{bean}")
    public Persona getBeanPersona(@PathVariable("bean") String nombre) {
        return (Persona) BS2Application.configurableApplicationContext.getBean(nombre);
    }
}
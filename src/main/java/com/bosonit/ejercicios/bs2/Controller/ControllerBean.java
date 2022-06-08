package com.bosonit.ejercicios.bs2.Controller;

import com.bosonit.ejercicios.RunApplication;
import com.bosonit.ejercicios.bs2.Class.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBean {
    @GetMapping("/controlador/bean/{bean}")
    public Persona getBeanPersona(@PathVariable("bean") String nombre) {
        return (Persona) RunApplication.configurableApplicationContext.getBean(nombre);
    }
}
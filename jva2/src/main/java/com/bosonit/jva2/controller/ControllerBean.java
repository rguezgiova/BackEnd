package com.bosonit.jva2.controller;

import com.bosonit.jva2.Jva2Application;
import com.bosonit.jva2.classes.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBean {
    @GetMapping()
    public Persona getBean(@PathVariable("bean") String bean) {
        return (Persona) Jva2Application.configurableApplicationContext.getBean(bean);
    }
}
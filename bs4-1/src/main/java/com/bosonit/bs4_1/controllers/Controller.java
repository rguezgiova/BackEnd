package com.bosonit.bs4_1.controllers;

import com.bosonit.bs4_1.Bs41Application;
import com.bosonit.bs4_1.classes.PerfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    PerfilesService perfilesService;

    @GetMapping("/parametros")
    public String getParametros(@Value("${url}") String url, @Value("${password}") String password) {
        return "URL: " + url + ", Password: " + password;
    }

    @GetMapping("/miconfiguracion")
    public String getConfiguracion() {
        Config config = Bs41Application.configurableApplicationContext.getBean(Config.class);
        return "Valor 1: " + config.getValor1() + ", valor 2: " + config.getValor2();
    }

    @GetMapping("/perfil")
    public void getPerfil() {
        perfilesService.miFuncion();
    }
}
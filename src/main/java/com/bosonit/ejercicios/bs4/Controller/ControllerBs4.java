package com.bosonit.ejercicios.bs4.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ConfigurationProperties
@RestController
public class ControllerBs4 {

    @GetMapping("/valores")
    public String getValores(@Value("${VAR1}") String primerValor, @Value("${My.VAR2}") int segundoValor) {
        return "Valor de VAR1: " + primerValor + ", valor de My.VAR2: " + segundoValor;
    }

    @GetMapping("/var3")
    public String getValorTres(@Value("${VAR3: No tiene valor}") String tercerValor) {
        return "Valor de VAR3: " + tercerValor;
    }
}
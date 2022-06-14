package com.bosonit.bs4_1.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("miconfiguracion.properties")
public class Config {
    private final String valor1;
    private final String valor2;

    Config(@Value("${valor1}") String valor1, @Value("${valor2}") String valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public String getValor1() {
        return valor1;
    }

    public String getValor2() {
        return valor2;
    }
}
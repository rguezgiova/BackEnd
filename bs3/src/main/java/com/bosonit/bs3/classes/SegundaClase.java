package com.bosonit.bs3.classes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SegundaClase {

    @Bean
    CommandLineRunner segundaFuncion() {
        return  p -> {
            System.out.println("Hola desde clase secundaria");
        };
    }
}
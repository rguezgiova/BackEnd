package com.bosonit.bs3.classes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TerceraClase {

    @Bean
    CommandLineRunner terceraFuncion() {
        return  p -> {
            System.out.println("Soy la tercera clase");
        };
    }
}
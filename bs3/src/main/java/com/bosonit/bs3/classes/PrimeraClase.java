package com.bosonit.bs3.classes;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PrimeraClase {

    @PostConstruct
    public void primeraClase() {
        System.out.println("Hola desde clase inicial");
    }
}
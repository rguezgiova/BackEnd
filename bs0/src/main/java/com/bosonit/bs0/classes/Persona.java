package com.bosonit.bs0.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private String nombre;
    private int edad;
    private String poblacion;
}
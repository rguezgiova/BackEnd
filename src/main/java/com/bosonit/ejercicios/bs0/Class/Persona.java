package com.bosonit.ejercicios.bs0.Class;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private String nombre;
    private int edad;
    private String poblacion;
}
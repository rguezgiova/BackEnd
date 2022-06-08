package com.bosonit.ejercicios.bs2.Class;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Persona {
    private String nombre;
    private int edad;
    private String poblacion;
}
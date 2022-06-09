package com.bosonit.ejercicios.rs1.Class;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Persona {
    private Integer id;
    private String nombre;
    private Integer edad;
    private String poblacion;
}
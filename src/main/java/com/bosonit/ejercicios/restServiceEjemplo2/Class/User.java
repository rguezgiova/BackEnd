package com.bosonit.ejercicios.restServiceEjemplo2.Class;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Integer id;
    private String nombre;
}
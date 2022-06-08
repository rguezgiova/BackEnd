package com.bosonit.ejercicios.bs2.Class;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ciudad {
    private String nombre;
    private int numeroHabitantes;
}
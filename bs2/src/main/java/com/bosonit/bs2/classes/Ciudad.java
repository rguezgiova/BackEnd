package com.bosonit.bs2.classes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ciudad {
    private String nombre;
    private int numeroHabitantes;
}
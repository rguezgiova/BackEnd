package com.bosonit.ej3_1.estudiante.application.port;

import com.bosonit.ej3_1.estudiante.domain.Estudiante;

public interface GetEstudiantePort {
    Estudiante getEstudianteId(String id);
}
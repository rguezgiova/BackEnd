package com.bosonit.bs12.estudiante.application.port;

import com.bosonit.bs12.estudiante.domain.Estudiante;

public interface GetEstudiantePort {
    Estudiante getEstudianteId(String id);
}
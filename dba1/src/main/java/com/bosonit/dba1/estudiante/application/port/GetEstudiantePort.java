package com.bosonit.dba1.estudiante.application.port;

import com.bosonit.dba1.estudiante.domain.Estudiante;

public interface GetEstudiantePort {
    Estudiante getEstudianteId(String id);
}
package com.bosonit.docker.estudiante.application.port;

import com.bosonit.docker.estudiante.domain.Estudiante;

public interface GetEstudiantePort {
    Estudiante getEstudianteId(String id);
}
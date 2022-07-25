package com.bosonit.dba1.estudiante.application;

import com.bosonit.dba1.estudiante.application.port.GetEstudiantePort;
import com.bosonit.dba1.estudiante.domain.Estudiante;
import com.bosonit.dba1.estudiante.infraestructure.repository.EstudianteRepository;
import com.bosonit.dba1.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetEstudianteUseCase implements GetEstudiantePort {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public Estudiante getEstudianteId(String id) {
        return estudianteRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún estudiante con dicha ID"));
    }
}
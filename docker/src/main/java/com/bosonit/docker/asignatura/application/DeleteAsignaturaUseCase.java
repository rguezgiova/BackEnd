package com.bosonit.docker.asignatura.application;

import com.bosonit.docker.asignatura.application.port.DeleteAsignaturaPort;
import com.bosonit.docker.asignatura.infraestructure.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAsignaturaUseCase implements DeleteAsignaturaPort {
    @Autowired
    AsignaturaRepository estudioRepository;

    @Override
    public void deleteAsignatura(String id) {
        estudioRepository.deleteById(id);
    }
}
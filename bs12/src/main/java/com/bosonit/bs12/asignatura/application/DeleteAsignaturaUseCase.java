package com.bosonit.bs12.asignatura.application;

import com.bosonit.bs12.asignatura.application.port.DeleteAsignaturaPort;
import com.bosonit.bs12.asignatura.infraestructure.repository.AsignaturaRepository;
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
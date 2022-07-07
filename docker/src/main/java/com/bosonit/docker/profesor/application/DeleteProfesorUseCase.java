package com.bosonit.docker.profesor.application;

import com.bosonit.docker.profesor.application.port.DeleteProfesorPort;
import com.bosonit.docker.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProfesorUseCase implements DeleteProfesorPort {
    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public void deleteProfesor(String id) {
        profesorRepository.deleteById(id);
    }
}
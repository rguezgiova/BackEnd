package com.bosonit.bs12.profesor.application;

import com.bosonit.bs12.profesor.application.port.DeleteProfesorPort;
import com.bosonit.bs12.profesor.infraestructure.repository.ProfesorRepository;
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
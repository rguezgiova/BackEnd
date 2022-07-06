package com.bosonit.bs12.profesor.application;

import com.bosonit.bs12.exception.NotFoundException;
import com.bosonit.bs12.profesor.application.port.GetProfesorPort;
import com.bosonit.bs12.profesor.domain.Profesor;
import com.bosonit.bs12.profesor.infraestructure.dto.output.ProfesorOutputDto;
import com.bosonit.bs12.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProfesorUseCase implements GetProfesorPort {
    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public ProfesorOutputDto getProfesorId(String id) {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún profesor con dicha ID"));
        return new ProfesorOutputDto(profesor);
    }
}

package com.bosonit.ej3_1.profesor.application;

import com.bosonit.ej3_1.exception.NotFoundException;
import com.bosonit.ej3_1.profesor.application.port.GetProfesorPort;
import com.bosonit.ej3_1.profesor.domain.Profesor;
import com.bosonit.ej3_1.profesor.infraestructure.dto.output.ProfesorOutputDto;
import com.bosonit.ej3_1.profesor.infraestructure.repository.ProfesorRepository;
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

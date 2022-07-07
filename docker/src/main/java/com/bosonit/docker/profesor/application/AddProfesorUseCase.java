package com.bosonit.docker.profesor.application;

import com.bosonit.docker.exception.NotFoundException;
import com.bosonit.docker.persona.domain.Persona;
import com.bosonit.docker.persona.infraestructure.repository.PersonaRepository;
import com.bosonit.docker.profesor.application.port.AddProfesorPort;
import com.bosonit.docker.profesor.domain.Profesor;
import com.bosonit.docker.profesor.infraestructure.dto.input.ProfesorInputDto;
import com.bosonit.docker.profesor.infraestructure.dto.output.ProfesorOutputDto;
import com.bosonit.docker.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddProfesorUseCase implements AddProfesorPort {
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public ProfesorOutputDto addProfesor(ProfesorInputDto profesorInputDto) {
        Persona persona = personaRepository.findById(profesorInputDto.getIdPersona()).orElseThrow(() -> new NotFoundException("No se ha encontrado ninguna persona con dicho ID"));
        Profesor profesor = new Profesor(profesorInputDto);
        profesor.setPersona(persona);
        profesorRepository.save(profesor);
        return new ProfesorOutputDto(profesor);
    }
}
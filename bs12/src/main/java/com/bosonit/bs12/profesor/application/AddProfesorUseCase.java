package com.bosonit.bs12.profesor.application;

import com.bosonit.bs12.exception.NotFoundException;
import com.bosonit.bs12.persona.domain.Persona;
import com.bosonit.bs12.persona.infraestructure.repository.PersonaRepository;
import com.bosonit.bs12.profesor.application.port.AddProfesorPort;
import com.bosonit.bs12.profesor.domain.Profesor;
import com.bosonit.bs12.profesor.infraestructure.dto.input.ProfesorInputDto;
import com.bosonit.bs12.profesor.infraestructure.dto.output.ProfesorOutputDto;
import com.bosonit.bs12.profesor.infraestructure.repository.ProfesorRepository;
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
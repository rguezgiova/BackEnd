package com.bosonit.dba1.profesor.application;

import com.bosonit.dba1.exception.NotFoundException;
import com.bosonit.dba1.persona.domain.Persona;
import com.bosonit.dba1.persona.infraestructure.repository.PersonaRepository;
import com.bosonit.dba1.profesor.application.port.AddProfesorPort;
import com.bosonit.dba1.profesor.domain.Profesor;
import com.bosonit.dba1.profesor.infraestructure.dto.input.ProfesorInputDto;
import com.bosonit.dba1.profesor.infraestructure.dto.output.ProfesorOutputDto;
import com.bosonit.dba1.profesor.infraestructure.repository.ProfesorRepository;
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
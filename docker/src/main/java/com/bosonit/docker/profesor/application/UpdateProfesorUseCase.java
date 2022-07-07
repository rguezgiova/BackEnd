package com.bosonit.docker.profesor.application;

import com.bosonit.docker.exception.NotFoundException;
import com.bosonit.docker.persona.domain.Persona;
import com.bosonit.docker.persona.infraestructure.repository.PersonaRepository;
import com.bosonit.docker.profesor.application.port.UpdateProfesorPort;
import com.bosonit.docker.profesor.domain.Profesor;
import com.bosonit.docker.profesor.infraestructure.dto.input.ProfesorInputDto;
import com.bosonit.docker.profesor.infraestructure.dto.output.ProfesorOutputDto;
import com.bosonit.docker.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfesorUseCase implements UpdateProfesorPort {
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public ProfesorOutputDto updateProfesor(String id, ProfesorInputDto profesorInputDto) {
        Profesor profesorEncontrado = profesorRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún profesor con dicha ID"));
        Persona persona = personaRepository.findById(profesorInputDto.getIdPersona()).orElseThrow(() -> new NotFoundException("No se ha encontrado ninguna persona con dicha ID"));
        profesorEncontrado.update(profesorInputDto);
        profesorEncontrado.setPersona(persona);
        profesorRepository.save(profesorEncontrado);
        return new ProfesorOutputDto(profesorEncontrado);
    }
}
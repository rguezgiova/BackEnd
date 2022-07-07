package com.bosonit.docker.estudiante.application;

import com.bosonit.docker.estudiante.application.port.UpdateEstudiantePort;
import com.bosonit.docker.estudiante.domain.Estudiante;
import com.bosonit.docker.estudiante.infraestructure.dto.input.EstudianteInputDto;
import com.bosonit.docker.estudiante.infraestructure.dto.output.EstudianteOutputDto;
import com.bosonit.docker.estudiante.infraestructure.repository.EstudianteRepository;
import com.bosonit.docker.exception.NotFoundException;
import com.bosonit.docker.persona.domain.Persona;
import com.bosonit.docker.persona.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateEstudianteUseCase implements UpdateEstudiantePort {
    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Estudiante getEstudianteId(String id) {
        return estudianteRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún estudiante con dicha ID"));
    }

    @Override
    public EstudianteOutputDto updateEstudiante(String id, EstudianteInputDto estudianteInputDto) {
        Estudiante estudianteEncontrado = getEstudianteId(id);
        Persona persona = personaRepository.findById(estudianteInputDto.getIdPersona()).orElseThrow(() -> new NotFoundException("No se ha encontrado ninguna persona con dicha ID"));
        estudianteEncontrado.update(estudianteInputDto);
        estudianteEncontrado.setPersona(persona);
        estudianteRepository.save(estudianteEncontrado);
        return new EstudianteOutputDto(estudianteEncontrado);
    }
}
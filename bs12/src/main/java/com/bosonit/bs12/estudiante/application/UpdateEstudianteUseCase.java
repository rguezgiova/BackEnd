package com.bosonit.bs12.estudiante.application;

import com.bosonit.bs12.estudiante.application.port.UpdateEstudiantePort;
import com.bosonit.bs12.estudiante.domain.Estudiante;
import com.bosonit.bs12.estudiante.infraestructure.dto.input.EstudianteInputDto;
import com.bosonit.bs12.estudiante.infraestructure.dto.output.EstudianteOutputDto;
import com.bosonit.bs12.estudiante.infraestructure.repository.EstudianteRepository;
import com.bosonit.bs12.exception.NotFoundException;
import com.bosonit.bs12.persona.domain.Persona;
import com.bosonit.bs12.persona.infraestructure.repository.PersonaRepository;
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
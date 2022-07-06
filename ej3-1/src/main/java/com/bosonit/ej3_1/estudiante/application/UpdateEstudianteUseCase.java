package com.bosonit.ej3_1.estudiante.application;

import com.bosonit.ej3_1.estudiante.application.port.UpdateEstudiantePort;
import com.bosonit.ej3_1.estudiante.domain.Estudiante;
import com.bosonit.ej3_1.estudiante.infraestructure.dto.input.EstudianteInputDto;
import com.bosonit.ej3_1.estudiante.infraestructure.dto.output.EstudianteOutputDto;
import com.bosonit.ej3_1.estudiante.infraestructure.repository.EstudianteRepository;
import com.bosonit.ej3_1.exception.NotFoundException;
import com.bosonit.ej3_1.persona.domain.Persona;
import com.bosonit.ej3_1.persona.infraestructure.repository.PersonaRepository;
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
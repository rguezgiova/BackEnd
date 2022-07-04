package com.bosonit.ej3_1.estudiante.application;

import com.bosonit.ej3_1.asignatura.domain.Asignatura;
import com.bosonit.ej3_1.asignatura.infraestructure.repository.AsignaturaRepository;
import com.bosonit.ej3_1.estudiante.application.port.AddEstudiantePort;
import com.bosonit.ej3_1.estudiante.domain.Estudiante;
import com.bosonit.ej3_1.estudiante.infraestructure.dto.input.EstudianteInputDto;
import com.bosonit.ej3_1.estudiante.infraestructure.dto.output.EstudianteOutputDto;
import com.bosonit.ej3_1.estudiante.infraestructure.repository.EstudianteRepository;
import com.bosonit.ej3_1.exception.NotFoundException;
import com.bosonit.ej3_1.persona.domain.Persona;
import com.bosonit.ej3_1.persona.infraestructure.repository.PersonaRepository;
import com.bosonit.ej3_1.profesor.domain.Profesor;
import com.bosonit.ej3_1.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddEstudianteUseCase implements AddEstudiantePort {
    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public EstudianteOutputDto addEstudiante(EstudianteInputDto estudianteInputDto) {
        Persona persona = personaRepository.findById(estudianteInputDto.getIdPersona()).orElseThrow(() -> new NotFoundException("No se encuentra ninguna persona con dicha ID"));
        Profesor profesor = null;
        if (estudianteInputDto.getIdProfesor() != null) {
            profesor = profesorRepository.findById(estudianteInputDto.getIdProfesor()).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún profesor con dicha ID"));
        }
        List<Asignatura> asignaturas = getAsignaturasIds(estudianteInputDto.getAsignaturas());
        Estudiante estudiante = new Estudiante(estudianteInputDto);
        estudiante.setPersona(persona);
        estudiante.setProfesor(profesor);
        estudiante.setAsignaturas(asignaturas);
        asignaturas.forEach(asignatura -> asignatura.addEstudiante(estudiante));
        estudianteRepository.save(estudiante);
        return new EstudianteOutputDto(estudiante);
    }

    @Override
    public EstudianteOutputDto addAsignaturas(String idEstudiante, List<String> asignaturasInsert) {
        Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún estudiante con dicha ID"));
        List<String> idsAsignaturas = estudiante.getAsignaturas().stream().map(Asignatura::getIdAsignatura).collect(Collectors.toList());
        idsAsignaturas.addAll(asignaturasInsert);
        List<Asignatura> asignaturas = getAsignaturasIds(idsAsignaturas.stream().distinct().collect(Collectors.toList()));
        estudiante.setAsignaturas(asignaturas);
        asignaturas.forEach(asignatura -> asignatura.addEstudiante(estudiante));
        estudianteRepository.save(estudiante);
        return new EstudianteOutputDto(estudiante);
    }

    private List<Asignatura> getAsignaturasIds(List<String> ids) {
        List<Asignatura> asignaturas = new ArrayList<>();
        if (ids != null) {
            asignaturas = asignaturaRepository.findAllById(ids);
            if (ids.size() != asignaturas.size()) {
                throw new NotFoundException("No se ha/han encontrado asignatura/s con dicha/s ID/S");
            }
        }
        return asignaturas;
    }
}
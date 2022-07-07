package com.bosonit.docker.asignatura.application;

import com.bosonit.docker.asignatura.application.port.AddAsignaturaPort;
import com.bosonit.docker.asignatura.domain.Asignatura;
import com.bosonit.docker.asignatura.infraestructure.dto.input.AsignaturaInputDto;
import com.bosonit.docker.asignatura.infraestructure.dto.output.AsignaturaOutputDto;
import com.bosonit.docker.asignatura.infraestructure.repository.AsignaturaRepository;
import com.bosonit.docker.estudiante.domain.Estudiante;
import com.bosonit.docker.estudiante.infraestructure.repository.EstudianteRepository;
import com.bosonit.docker.exception.NotFoundException;
import com.bosonit.docker.profesor.domain.Profesor;
import com.bosonit.docker.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddAsignaturaUseCase implements AddAsignaturaPort {
    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto) {
        Asignatura asignatura = new Asignatura(asignaturaInputDto);
        if (asignaturaInputDto.getIdProfesor() != null) {
            asignatura.setProfesor(getProfesor(asignaturaInputDto.getIdProfesor()));
        }
        List<Estudiante> estudiantes = getEstudiantesIds(asignaturaInputDto.getIdsEstudiantes());
        asignatura.setEstudiantes(estudiantes);
        asignaturaRepository.save(asignatura);
        return new AsignaturaOutputDto(asignatura);
    }

    private Profesor getProfesor(String id) {
        return profesorRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún profesor con dicha ID"));
    }

    private List<Estudiante> getEstudiantesIds(List<String> ids) {
        List<Estudiante> estudiantes = new ArrayList<>();
        if (ids != null) {
            estudiantes = estudianteRepository.findAllById(ids);
            if(ids.size() != estudiantes.size()) {
                throw new NotFoundException("No se han encontrado uno o varios estudiantes con dichas IDS");
            }
        }
        return estudiantes;
    }
}
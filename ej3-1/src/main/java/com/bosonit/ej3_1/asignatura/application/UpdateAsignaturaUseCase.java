package com.bosonit.ej3_1.asignatura.application;

import com.bosonit.ej3_1.asignatura.application.port.UpdateAsignaturaPort;
import com.bosonit.ej3_1.asignatura.domain.Asignatura;
import com.bosonit.ej3_1.asignatura.infraestructure.dto.input.AsignaturaInputDto;
import com.bosonit.ej3_1.asignatura.infraestructure.dto.output.AsignaturaOutputDto;
import com.bosonit.ej3_1.asignatura.infraestructure.repository.AsignaturaRepository;
import com.bosonit.ej3_1.estudiante.domain.Estudiante;
import com.bosonit.ej3_1.estudiante.infraestructure.repository.EstudianteRepository;
import com.bosonit.ej3_1.exception.NotFoundException;
import com.bosonit.ej3_1.profesor.domain.Profesor;
import com.bosonit.ej3_1.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateAsignaturaUseCase implements UpdateAsignaturaPort {
    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public AsignaturaOutputDto updateAsignatura(String id, AsignaturaInputDto asignaturaInputDto) {
        Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado ninguna asignatura con dicha ID"));
        asignatura.update(asignaturaInputDto);
        if (asignaturaInputDto.getIdProfesor() != null) {
            asignatura.setProfesor(getProfesor(asignaturaInputDto.getIdProfesor()));
        }
        List<String> estudiantes = new ArrayList<>(asignatura.getEstudiantes().stream().map(Estudiante::getIdEstudiante).toList());
        estudiantes.addAll(asignaturaInputDto.getIdsEstudiantes());
        asignatura.setEstudiantes(getEstudiantesIds(estudiantes.stream().distinct().toList()));
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
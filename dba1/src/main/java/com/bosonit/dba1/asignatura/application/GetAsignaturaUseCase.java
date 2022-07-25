package com.bosonit.dba1.asignatura.application;

import com.bosonit.dba1.asignatura.infraestructure.dto.output.AsignaturaOutputDto;
import com.bosonit.dba1.estudiante.domain.Estudiante;
import com.bosonit.dba1.estudiante.infraestructure.repository.EstudianteRepository;
import com.bosonit.dba1.asignatura.application.port.GetAsignaturaPort;
import com.bosonit.dba1.asignatura.infraestructure.repository.AsignaturaRepository;
import com.bosonit.dba1.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAsignaturaUseCase implements GetAsignaturaPort {
    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public AsignaturaOutputDto getAsignaturaById(String id) {
        return new AsignaturaOutputDto(asignaturaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encuentra ninguna asignatura con dicho ID")));
    }

    @Override
    public List<AsignaturaOutputDto> getAsignaturaEstudianteById(String idEstudiante) {
        Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún estudiante con dicha ID"));
        return estudiante.getAsignaturas().stream().map(AsignaturaOutputDto::new).collect(Collectors.toList());
    }
}
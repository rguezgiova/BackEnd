package com.bosonit.docker.estudiante.application;

import com.bosonit.docker.asignatura.domain.Asignatura;
import com.bosonit.docker.asignatura.infraestructure.repository.AsignaturaRepository;
import com.bosonit.docker.estudiante.application.port.DeleteEstudiantePort;
import com.bosonit.docker.estudiante.domain.Estudiante;
import com.bosonit.docker.estudiante.infraestructure.dto.output.EstudianteOutputDto;
import com.bosonit.docker.estudiante.infraestructure.repository.EstudianteRepository;
import com.bosonit.docker.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeleteEstudianteUseCase implements DeleteEstudiantePort {
    @Autowired
    EstudianteRepository estudianteRepository;
    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public void deleteEstudiante(String id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public EstudianteOutputDto deleteAsignaturas(String idEstudiante, List<String> asignaturasDelete) {
        Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún estudiante con dicha ID"));
        List<Asignatura> asignaturas = getAsignaturasIds(asignaturasDelete);
        estudiante.getAsignaturas().removeAll(asignaturas);
        asignaturas.forEach(asignatura -> asignatura.deleteEstudiante(estudiante));
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
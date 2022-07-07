package com.bosonit.docker.estudiante.infraestructure.dto.output;

import com.bosonit.docker.asignatura.domain.Asignatura;
import com.bosonit.docker.estudiante.domain.Estudiante;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class EstudianteOutputDto {
    private String idEstudiante;
    private String idPersona;
    private String idProfesor;
    private int numHoursWeek;
    private String comments;
    private String branch;
    private List<String> asignaturas = new ArrayList<>();

    public EstudianteOutputDto(Estudiante estudiante) {
        setIdEstudiante(estudiante.getIdEstudiante());
        setIdPersona(estudiante.getPersona().getIdPersona());
        setIdProfesor(estudiante.getProfesor().getIdProfesor());
        setNumHoursWeek(estudiante.getNumHoursWeek());
        setComments(estudiante.getComments());
        setBranch(estudiante.getBranch());
        setAsignaturas(estudiante.getAsignaturas().stream().map(Asignatura::getIdAsignatura).toList());
    }
}
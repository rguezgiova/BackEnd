package com.bosonit.dba1.estudiante.infraestructure.dto.input;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class EstudianteInputDto {
    @NotNull(message = "Los datos del alumno no pueden estar vacíos")
    private String idPersona;
    private String idProfesor;
    private int numHoursWeek;
    private String comments;
    @NotEmpty(message = "El alumno debe tener un profesor")
    private String profesor;
    @NotEmpty(message = "El alumno debe pertenecer a una rama")
    private String branch;
    private List<String> asignaturas = new ArrayList<>();
}
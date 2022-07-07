package com.bosonit.docker.asignatura.infraestructure.dto.input;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class AsignaturaInputDto {
    @NotNull(message = "La asignatura debe tener un profesor")
    private String idProfesor;
    @NotNull(message = "La asignatura debe tener un nombre")
    private String name;
    private String comments;
    private Date initialDate;
    private Date finishDate;
    private List<String> idsEstudiantes;
}
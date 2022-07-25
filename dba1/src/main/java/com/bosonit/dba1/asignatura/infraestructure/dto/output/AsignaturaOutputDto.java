package com.bosonit.dba1.asignatura.infraestructure.dto.output;

import com.bosonit.dba1.asignatura.domain.Asignatura;
import com.bosonit.dba1.estudiante.domain.Estudiante;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AsignaturaOutputDto {
    private String idAsignatura;
    private String idProfesor;
    private String name;
    private String comments;
    private Date initialDate;
    private Date finishDate;
    private List<String> idsEstudiantes;

    public AsignaturaOutputDto(Asignatura asignatura) {
        setIdAsignatura(asignatura.getIdAsignatura());
        setName(asignatura.getName());
        setComments(asignatura.getComments());
        setInitialDate(asignatura.getInitialDate());
        setFinishDate(asignatura.getFinishDate());
        setIdsEstudiantes(asignatura.getEstudiantes().stream().map(Estudiante::getIdEstudiante).collect(Collectors.toList()));
    }
}
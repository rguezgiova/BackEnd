package com.bosonit.ej3_1.profesor.infraestructure.dto.output;

import com.bosonit.ej3_1.profesor.domain.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfesorOutputDto {
    private String idProfesor;
    private String idPersona;
    private String comments;
    private String branch;

    public ProfesorOutputDto(Profesor profesor) {
        setIdProfesor(profesor.getIdProfesor());
        setIdPersona(profesor.getPersona().getIdPersona());
        setComments(profesor.getComments());
        setBranch(profesor.getBranch());
    }
}
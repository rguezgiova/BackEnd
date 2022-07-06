package com.bosonit.bs12.profesor.infraestructure.dto.input;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ProfesorInputDto {
    @NotEmpty(message = "Los datos no pueden estar vacíos")
    private String idPersona;
    private String comments;
    @NotEmpty(message = "El profesor debe pertenecer a una rama")
    private String branch;
}
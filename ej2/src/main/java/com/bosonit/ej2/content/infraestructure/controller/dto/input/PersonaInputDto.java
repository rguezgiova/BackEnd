package com.bosonit.ej2.content.infraestructure.controller.dto.input;

import lombok.Data;

import java.util.Date;

@Data
public class PersonaInputDto {
    private int idPersona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private boolean active;
    private Date createDate;
    private String imagenUrl;
    private Date terminationDate;
}
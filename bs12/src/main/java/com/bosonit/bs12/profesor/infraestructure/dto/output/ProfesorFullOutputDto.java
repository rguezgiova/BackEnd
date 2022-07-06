package com.bosonit.bs12.profesor.infraestructure.dto.output;

import com.bosonit.bs12.profesor.domain.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ProfesorFullOutputDto extends ProfesorOutputDto {
    private String idPersona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private Date createdDate;
    private String imageUrl;
    private Date terminationDate;

    public ProfesorFullOutputDto(Profesor profesor) {
        super(profesor);
        setIdPersona(profesor.getPersona().getIdPersona());
        setUsuario(profesor.getPersona().getUsuario());
        setName(profesor.getPersona().getName());
        setSurname(profesor.getPersona().getSurname());
        setCompanyEmail(profesor.getPersona().getCompanyEmail());
        setPersonalEmail(profesor.getPersona().getPersonalEmail());
        setCity(profesor.getPersona().getCity());
        setActive(profesor.getPersona().isActive());
        setCreatedDate(profesor.getPersona().getCreatedDate());
        setImageUrl(profesor.getPersona().getImageUrl());
        setTerminationDate(profesor.getPersona().getTerminationDate());
    }
}
package com.bosonit.bp1.content.infraestructure.dto.output;

import com.bosonit.bp1.content.domain.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaOutputDto {
    private int idPersona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private boolean active;
    private Date createdDate;
    private String imageUrl;
    private Date terminationDate;

    public PersonaOutputDto(Persona persona) {
        setIdPersona(persona.getIdPersona());
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompanyEmail(persona.getCompanyEmail());
        setPersonalEmail(persona.getPersonalEmail());
        setCity(persona.getCity());
        setActive(persona.isActive());
        setCreatedDate(persona.getCreatedDate());
        setImageUrl(persona.getImageUrl());
        setTerminationDate(persona.getTerminationDate());
    }
}
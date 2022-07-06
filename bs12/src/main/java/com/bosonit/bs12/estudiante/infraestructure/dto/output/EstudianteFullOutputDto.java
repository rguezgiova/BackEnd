package com.bosonit.bs12.estudiante.infraestructure.dto.output;

import com.bosonit.bs12.estudiante.domain.Estudiante;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class EstudianteFullOutputDto extends EstudianteOutputDto {
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

    public EstudianteFullOutputDto(Estudiante estudiante) {
        super(estudiante);
        setIdPersona(estudiante.getPersona().getIdPersona());
        setUsuario(estudiante.getPersona().getUsuario());
        setName(estudiante.getPersona().getName());
        setSurname(estudiante.getPersona().getSurname());
        setCompanyEmail(estudiante.getPersona().getCompanyEmail());
        setPersonalEmail(estudiante.getPersona().getPersonalEmail());
        setCity(estudiante.getPersona().getCity());
        setActive(estudiante.getPersona().isActive());
        setCreatedDate(estudiante.getPersona().getCreatedDate());
        setImageUrl(estudiante.getPersona().getImageUrl());
        setTerminationDate(estudiante.getPersona().getTerminationDate());
    }
}
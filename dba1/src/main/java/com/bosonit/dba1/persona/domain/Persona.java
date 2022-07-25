package com.bosonit.dba1.persona.domain;

import com.bosonit.dba1.PersonaSequenceIdGenerator;
import com.bosonit.dba1.persona.infraestructure.dto.input.PersonaInputDto;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idPersona")
    @GenericGenerator(name = "idPersona",
            strategy = "com.bosonit.dba1.PersonaSequenceIdGenerator",
            parameters = {
                @Parameter(name = PersonaSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                @Parameter(name = PersonaSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "user"),
                @Parameter(name = PersonaSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String  idPersona;
    @Column
    private String usuario;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String companyEmail;
    @Column
    private String personalEmail;
    @Column
    private String city;
    @Column
    private boolean active;
    @Column
    private Date createdDate;
    @Column
    private String imageUrl;
    @Column
    private Date terminationDate;

    public Persona(PersonaInputDto personaInputDto) {
        setUsuario(personaInputDto.getUsuario());
        setName(personaInputDto.getName());
        setPassword(personaInputDto.getPassword());
        setCompanyEmail(personaInputDto.getCompanyEmail());
        setPersonalEmail(personaInputDto.getPersonalEmail());
        setCity(personaInputDto.getCity());
        setCreatedDate(new Date());
        setActive(true);
        setImageUrl(personaInputDto.getImagenUrl());
        setSurname(personaInputDto.getSurname());
    }

    public void update(PersonaInputDto personaInputDto) {
        if (personaInputDto.getUsuario() != null && personaInputDto.getUsuario().length() <= 10 && personaInputDto.getUsuario().length() >= 6) {
            setUsuario(personaInputDto.getUsuario());
        }
        if (personaInputDto.getName() != null) {
            setName(personaInputDto.getName());
        }
        if (personaInputDto.getSurname() != null) {
            setSurname(personaInputDto.getSurname());
        }
        if (personaInputDto.getPassword() != null) {
            setPassword(personaInputDto.getPassword());
        }
        if (personaInputDto.getCompanyEmail() != null) {
            setCompanyEmail(personaInputDto.getCompanyEmail());
        }
        if (personaInputDto.getPersonalEmail() != null) {
            setPersonalEmail(personaInputDto.getPersonalEmail());
        }
        if (personaInputDto.getCity() != null) {
            setCity(personaInputDto.getCity());
        }
        if (personaInputDto.getImagenUrl() != null) {
            setImageUrl(personaInputDto.getImagenUrl());
        }
    }
}
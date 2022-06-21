package com.bosonit.bp1.content.domain;

import com.bosonit.bp1.content.infraestructure.controller.dto.input.PersonaInputDto;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idPersona;
    @Column @NotNull
    private String usuario;
    @Column @NotNull
    private String password;
    @Column @NotNull
    private String name;
    @Column
    private String surname;
    @Column @NotNull
    private String companyEmail;
    @Column @NotNull
    private String personalEmail;
    @Column @NotNull
    private String city;
    @Column @NotNull
    private boolean active;
    @Column @NotNull
    private Date createdDate;
    @Column
    private String imageUrl;
    @Column
    private Date terminationDate;

    public Persona(PersonaInputDto personaInputDto) throws Exception{
        if(personaInputDto.getUsuario() != null
                && personaInputDto.getUsuario().length() <= 10
                && personaInputDto.getUsuario().length() >= 6
        ){
            setUsuario(personaInputDto.getUsuario());
        }else{
            throw new Exception("El campo usuario debe tener entre 6 y 10 caracteres");
        }
        if(personaInputDto.getName() == null){
            throw new Exception("El campo nombre no puede estar vacío");
        }else{
            setName(personaInputDto.getName());
        }
        if(personaInputDto.getPassword() == null){
            throw new Exception("El campo contraseña no puede estar vacío");
        }else{
            setPassword(personaInputDto.getPassword());
        }
        if(personaInputDto.getCompanyEmail() == null){
            throw new Exception("El campo email de compañia no puede estar vacío");
        }else{
            setCompanyEmail(personaInputDto.getCompanyEmail());
        }
        if(personaInputDto.getPersonalEmail() == null){
            throw new Exception("El campo email personal no puede estar vacío");
        }else{
            setPersonalEmail(personaInputDto.getPersonalEmail());
        }
        if(personaInputDto.getCity() == null){
            throw new Exception("El campo ciudad no puede estar vacío");
        }else{
            setCity(personaInputDto.getCity());
        }
        setCreatedDate(new Date());
        setActive(true);
        setImageUrl(personaInputDto.getImagenUrl());
        setSurname(personaInputDto.getSurname());
    }

    public void update(PersonaInputDto personaInputDto) throws Exception {
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
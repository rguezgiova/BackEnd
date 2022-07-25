package com.bosonit.dba2.persona.infraestructure.dto;

import com.bosonit.dba2.persona.domain.Persona;
import lombok.Data;

@Data
public class PersonaDto {
    private String id;
    private String user;
    private String password;
    private String name;
    private String surname;

    public PersonaDto(Persona persona) {
        setId(persona.getId());
        setUser(persona.getUser());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
    }

    public PersonaDto(String user, String password, String name, String surname) {
        setUser(user);
        setPassword(password);
        setName(name);
        setSurname(surname);
    }
}
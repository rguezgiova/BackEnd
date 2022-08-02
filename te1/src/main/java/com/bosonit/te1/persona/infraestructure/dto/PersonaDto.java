package com.bosonit.te1.persona.infraestructure.dto;

import com.bosonit.te1.persona.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaDto {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String surname;

    public PersonaDto(Persona persona) {
        setId(persona.getId());
        setUsername(persona.getUsername());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
    }

    public PersonaDto(Integer id, String user, String password, String name, String surname) {
        setId(id);
        setUsername(user);
        setPassword(password);
        setName(name);
        setSurname(surname);
    }
}
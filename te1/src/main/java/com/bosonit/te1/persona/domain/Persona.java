package com.bosonit.te1.persona.domain;

import com.bosonit.te1.persona.infraestructure.dto.PersonaDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Persona {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String surname;

    public Persona(PersonaDto personaDto) {
        setId(personaDto.getId());
        setUsername(personaDto.getUsername());
        setPassword(personaDto.getPassword());
        setName(personaDto.getName());
        setSurname(personaDto.getSurname());
    }
}
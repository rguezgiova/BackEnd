package com.bosonit.dba2.persona.domain;

import com.bosonit.dba2.persona.infraestructure.dto.PersonaDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Persona {
    @Id
    private String id;
    private String user;
    private String password;
    private String name;
    private String surname;

    public Persona(PersonaDto personaDto) {
        setId(personaDto.getId());
        setUser(personaDto.getUser());
        setPassword(personaDto.getPassword());
        setName(personaDto.getName());
        setSurname(personaDto.getSurname());
    }
}
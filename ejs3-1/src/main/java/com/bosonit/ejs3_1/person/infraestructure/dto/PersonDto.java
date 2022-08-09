package com.bosonit.ejs3_1.person.infraestructure.dto;

import com.bosonit.ejs3_1.role.domain.Role;
import com.bosonit.ejs3_1.person.domain.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
public class PersonDto {
    private Long id;
    private String name;
    private String username;
    private String password;
    private Collection<Role> roles = new ArrayList<>();

    public PersonDto(Person person) {
        setId(person.getId());
        setName(person.getName());
        setUsername(person.getUsername());
        setPassword(person.getPassword());
        setRoles(person.getRoles());
    }

    public PersonDto(Long id, String name, String username, String password, Collection<Role> roles) {
        setId(id);
        setName(name);
        setUsername(username);
        setPassword(password);
        setRoles(roles);
    }
}
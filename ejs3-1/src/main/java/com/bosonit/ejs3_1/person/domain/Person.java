package com.bosonit.ejs3_1.person.domain;

import com.bosonit.ejs3_1.role.domain.Role;
import com.bosonit.ejs3_1.person.infraestructure.dto.PersonDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public Person(PersonDto personDto) {
        setName(personDto.getName());
        setUsername(personDto.getUsername());
        setPassword(personDto.getPassword());
        setRoles(personDto.getRoles());
    }
}
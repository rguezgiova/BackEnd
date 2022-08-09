package com.bosonit.ejs3_1.role.domain;

import com.bosonit.ejs3_1.role.infraestructure.dto.RoleDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Role(RoleDto roleDto) {
        setName(roleDto.getName());
    }
}
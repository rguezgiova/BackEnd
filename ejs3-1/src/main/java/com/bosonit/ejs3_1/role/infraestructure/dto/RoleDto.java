package com.bosonit.ejs3_1.role.infraestructure.dto;

import com.bosonit.ejs3_1.role.domain.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDto {
    private Long id;
    private String name;

    public RoleDto(Role role) {
        setId(role.getId());
        setName(role.getName());
    }

    public RoleDto(Long id, String name) {
        setId(id);
        setName(name);
    }
}
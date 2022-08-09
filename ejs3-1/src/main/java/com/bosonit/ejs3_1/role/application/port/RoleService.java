package com.bosonit.ejs3_1.role.application.port;

import com.bosonit.ejs3_1.role.domain.Role;

import java.util.List;

public interface RoleService {
    Role addRole(Role role);
    void addRoleToUser(String username, String roleName);
    List<Role> getRoles();
}
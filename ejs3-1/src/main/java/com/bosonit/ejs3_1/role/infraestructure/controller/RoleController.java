package com.bosonit.ejs3_1.role.infraestructure.controller;

import com.bosonit.ejs3_1.role.application.port.RoleService;
import com.bosonit.ejs3_1.role.domain.Role;
import com.bosonit.ejs3_1.role.infraestructure.dto.RoleDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/role")
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public Role addRole(@RequestBody RoleDto roleDto) {
        return roleService.addRole(new Role(roleDto));
    }

    @GetMapping("/getall")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @PostMapping(value = "/addroletouser", consumes = {"multipart/form-data"})
    public void addRoleToUser(@ModelAttribute RoleToUserForm form) {
        roleService.addRoleToUser(form.getUsername(), form.getRole());
    }

    @Data
    class RoleToUserForm {
        private String username;
        private String role;
    }
}
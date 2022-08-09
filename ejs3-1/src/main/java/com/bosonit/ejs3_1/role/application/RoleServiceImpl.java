package com.bosonit.ejs3_1.role.application;

import com.bosonit.ejs3_1.role.application.port.RoleService;
import com.bosonit.ejs3_1.role.domain.Role;
import com.bosonit.ejs3_1.person.domain.Person;
import com.bosonit.ejs3_1.role.infraestructure.repository.RoleRepository;
import com.bosonit.ejs3_1.person.infraestructure.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PersonRepository personRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Person person = personRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        Collection<Role> roles = person.getRoles();
        if (!roles.contains(role)) {
            person.getRoles().add(role);
            personRepository.save(person);
        }
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
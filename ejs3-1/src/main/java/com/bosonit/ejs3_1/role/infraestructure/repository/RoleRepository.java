package com.bosonit.ejs3_1.role.infraestructure.repository;

import com.bosonit.ejs3_1.role.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
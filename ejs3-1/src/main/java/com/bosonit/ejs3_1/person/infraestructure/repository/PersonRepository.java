package com.bosonit.ejs3_1.person.infraestructure.repository;

import com.bosonit.ejs3_1.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);
}
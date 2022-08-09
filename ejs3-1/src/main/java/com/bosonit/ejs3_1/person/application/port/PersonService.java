package com.bosonit.ejs3_1.person.application.port;

import com.bosonit.ejs3_1.person.domain.Person;

import java.util.List;

public interface PersonService {
    Person addUser(Person person);
    Person getUserByUsername(String username);
    List<Person> getUsers();
    void deleteUser(Long id);
}
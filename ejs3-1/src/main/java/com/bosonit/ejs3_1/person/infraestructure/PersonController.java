package com.bosonit.ejs3_1.person.infraestructure;

import com.bosonit.ejs3_1.person.application.PersonServiceImpl;
import com.bosonit.ejs3_1.person.domain.Person;
import com.bosonit.ejs3_1.person.infraestructure.dto.PersonDto;
import com.bosonit.ejs3_1.person.infraestructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;
    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public Person addUser(@RequestBody PersonDto personDto) {
        return personService.addUser(new Person(personDto));
    }

    @GetMapping("/username/{username}")
    public Person getUserByUsername(@PathVariable("username") String username) {
        return personService.getUserByUsername(username);
    }

    @GetMapping("/getall")
    public List<Person> getUsers() {
        return personService.getUsers();
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        personService.deleteUser(id);
    }
}
package com.bosonit.ejs3_1.person.application;

import com.bosonit.ejs3_1.person.application.port.PersonService;
import com.bosonit.ejs3_1.person.domain.Person;
import com.bosonit.ejs3_1.person.infraestructure.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Component
@Transactional
@Slf4j
public class PersonServiceImpl implements PersonService, UserDetailsService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(username);
        if (person == null) {
            throw new UsernameNotFoundException("Person not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        person.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(person.getUsername(), person.getPassword(), authorities);
    }

    @Override
    public Person addUser(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        return personRepository.save(person);
    }

    @Override
    public Person getUserByUsername(String username) {
        return personRepository.findByUsername(username);
    }

    @Override
    public List<Person> getUsers() {
        return personRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        personRepository.deleteById(id);
    }
}
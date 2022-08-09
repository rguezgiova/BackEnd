package com.bosonit.ejs3_1;

import com.bosonit.ejs3_1.person.application.port.PersonService;
import com.bosonit.ejs3_1.person.domain.Person;
import com.bosonit.ejs3_1.person.infraestructure.dto.PersonDto;
import com.bosonit.ejs3_1.role.application.port.RoleService;
import com.bosonit.ejs3_1.role.domain.Role;
import com.bosonit.ejs3_1.role.infraestructure.dto.RoleDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class Ejs3_1Application {
	public static void main(String[] args) {
		SpringApplication.run(Ejs3_1Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(PersonService personService, RoleService roleService) {
		return args -> {
			personService.addUser(new Person(new PersonDto(null, "Giovanni", "grodriguez", "password", new ArrayList<>())));
			personService.addUser(new Person(new PersonDto(null, "Laura", "lvidal", "password", new ArrayList<>())));
			personService.addUser(new Person(new PersonDto(null, "Dylan", "drodriguez", "password", new ArrayList<>())));
			personService.addUser(new Person(new PersonDto(null, "Pedro", "prodriguez", "password", new ArrayList<>())));

			roleService.addRole(new Role(new RoleDto(null, "USER")));
			roleService.addRole(new Role(new RoleDto(null, "ADMIN")));

			roleService.addRoleToUser("grodriguez", "ADMIN");
			roleService.addRoleToUser("lvidal", "USER");
			roleService.addRoleToUser("drodriguez", "ADMIN");
			roleService.addRoleToUser("prodriguez", "USER");
		};
	}
}
package com.bosonit.jva2;

import com.bosonit.jva2.classes.Ciudad;
import com.bosonit.jva2.classes.Persona;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Jva2Application {
	public static ConfigurableApplicationContext configurableApplicationContext;

	public static void main(String[] args) {
		configurableApplicationContext = SpringApplication.run(Jva2Application.class, args);
	}

	@Bean
	public List<Ciudad> listaCiudades() {
		return new ArrayList<Ciudad>();
	}

	@Bean("giovanni")
	public Persona persona1() {
		return new Persona("Giovanni", 24, "SC de Tenerife");
	}

	@Bean("laura")
	public Persona persona2() {
		return new Persona("Laura", 23, "SC de Tenerife");
	}

	@Bean("pedro")
	public Persona persona3() {
		return new Persona("Pedro", 55, "SC de Tenerife");
	}
}
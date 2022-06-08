package com.bosonit.ejercicios.bs2.Application;

import com.bosonit.ejercicios.bs2.Class.Ciudad;
import com.bosonit.ejercicios.bs2.Class.Persona;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RunApplication {
	public static ConfigurableApplicationContext configurableApplicationContext;

	public static void main(String[] args) {
		configurableApplicationContext = SpringApplication.run(RunApplication.class, args);
	}

	@Bean
	public List<Ciudad> listaCiudades() {
		return new ArrayList<Ciudad>();
	}

	@Bean("giovanni")
	public Persona persona1() {
		return Persona.builder().nombre("Giovanni").edad(24).poblacion("SC de Tenerife").build();
	}

	@Bean("laura")
	public Persona persona2() {
		return Persona.builder().nombre("Laura").edad(24).poblacion("SC de Tenerife").build();
	}

	@Bean("pedro")
	public Persona persona3() {
		return Persona.builder().nombre("Pedro").edad(55).poblacion("SC de Tenerife").build();
	}
}
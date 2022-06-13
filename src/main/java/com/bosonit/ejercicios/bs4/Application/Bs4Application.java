package com.bosonit.ejercicios.bs4.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:bs4application.yml")
public class Bs4Application {
	public static void main(String[] args) {
		SpringApplication.run(Bs4Application.class, args);
	}
}
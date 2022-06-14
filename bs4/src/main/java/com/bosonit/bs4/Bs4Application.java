package com.bosonit.bs4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yml")
public class Bs4Application {
	public static void main(String[] args) {
		SpringApplication.run(Bs4Application.class, args);
	}
}
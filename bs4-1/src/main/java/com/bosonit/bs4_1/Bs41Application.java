package com.bosonit.bs4_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Bs41Application {
	public static ConfigurableApplicationContext configurableApplicationContext;

	public static void main(String[] args) {
		configurableApplicationContext = SpringApplication.run(Bs41Application.class, args);
	}
}
package com.bosonit.bs12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.bosonit.bs12.feign")
public class Bs12Application {
	public static void main(String[] args) {
		SpringApplication.run(Bs12Application.class, args);
	}
}
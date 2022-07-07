package com.bosonit.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.bosonit.docker.feign")
public class DockerApplication {
	public static void main(String[] args) {
		SpringApplication.run(DockerApplication.class, args);
	}
}
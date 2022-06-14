package com.bosonit.bs5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Bs5Application {
	public static void main(String[] args) {
		SpringApplication.run(Bs5Application.class, args);
		log.trace("TRACE message");
		log.debug("DEBUG message");
		log.info("INFO message");
		log.warn("WARN message");
		log.error("ERROR message");
	}
}
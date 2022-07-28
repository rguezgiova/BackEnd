package com.bosonit.sa2;

import com.bosonit.sa2.file.application.storage.StorageConfigurationProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageConfigurationProperties.class)
public class Sa2Application {
	public static void main(String[] args) {
		SpringApplication.run(Sa2Application.class, args);
	}

	@Bean
	CommandLineRunner init(StorageConfigurationProperties properties) {
		return (args -> {
			if (args.length > 0)
				properties.setPath(args[0]);
		});
	}
}
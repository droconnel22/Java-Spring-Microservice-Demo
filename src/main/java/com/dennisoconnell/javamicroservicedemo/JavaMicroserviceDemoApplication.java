package com.dennisoconnell.javamicroservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JavaMicroserviceDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(JavaMicroserviceDemoApplication.class, args);
	}

}

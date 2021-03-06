package com.dennisoconnell.javamicroservicedemo;

import com.dennisoconnell.javamicroservicedemo.trades.infrastructure.sql.TradeSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JavaMicroserviceDemoApplication implements CommandLineRunner {

	@Autowired
	TradeSeeder tradeSeeder;

	public static void main(String[] args) {

		SpringApplication.run(JavaMicroserviceDemoApplication.class, args);
	}

	@Override
	public void run(String... args){

	}

}

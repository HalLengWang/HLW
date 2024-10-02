package com.todorank.hlw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HlwApplication {

	public static void main(String[] args) {
		SpringApplication.run(HlwApplication.class, args);
	}

}

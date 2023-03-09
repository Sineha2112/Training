package com.project.evotingsystemspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class EvotingsystemSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvotingsystemSpringApplication.class, args);
		Logger logger = LoggerFactory.getLogger(EvotingsystemSpringApplication.class);
		logger.info("Application Started");
	}

}
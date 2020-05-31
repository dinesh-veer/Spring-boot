package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.controller")
public class SpringBootLoggingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggingDemoApplication.class, args);
	}

}

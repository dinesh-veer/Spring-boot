package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleSpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringBootDemoApplication.class, args);
	}
	
	@RequestMapping("/")
	public String welcomeMsg() {
		return "First Screen";
	}

}

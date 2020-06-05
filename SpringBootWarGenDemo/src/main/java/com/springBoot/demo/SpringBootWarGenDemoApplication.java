package com.springBoot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootWarGenDemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootWarGenDemoApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWarGenDemoApplication.class, args);
	}
	
	@RequestMapping("/welcome")
	public String welcomeMsg() {
		return "Welcome from WAR";
	}

}

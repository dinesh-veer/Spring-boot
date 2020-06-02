package com.springBoot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootRestTemplateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestTemplateDemoApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTempate() {
		return new RestTemplate();
	}
}

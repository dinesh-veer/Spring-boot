package com.springBoot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootRestXmlJsonDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestXmlJsonDemoApplication.class, args);
	}

}

package com.springBoot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootEurekaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEurekaDemoApplication.class, args);
	}

}

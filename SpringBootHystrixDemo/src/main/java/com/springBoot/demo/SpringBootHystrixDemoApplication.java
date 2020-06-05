package com.springBoot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class SpringBootHystrixDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHystrixDemoApplication.class, args);
	}

}

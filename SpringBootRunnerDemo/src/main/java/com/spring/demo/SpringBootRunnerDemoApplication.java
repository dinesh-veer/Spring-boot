package com.spring.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//User to initialise when application is started 
//Application Runner runs first then CommandLineRunner
public class SpringBootRunnerDemoApplication implements ApplicationRunner,CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRunnerDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("printing through Command Line Runner....");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("Printing through Application Runner...");
	}

}

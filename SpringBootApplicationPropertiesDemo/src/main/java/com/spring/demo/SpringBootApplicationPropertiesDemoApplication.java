package com.spring.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootApplicationPropertiesDemoApplication {
	// Default value assigned if no value found
	@Value("${name.properties:Veer}")
	public String name;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationPropertiesDemoApplication.class, args);
	}
	
	@GetMapping("/")
	public String getMessageFromProperties() {
		return "Got the message from Properties "+ name;
	}

}

//TO run from Command prompt the jar 
//use the mvn clean build to generate jar
//after that on build jar use 
//java -jar JARNAME --server-port=SERVERPORT
//Otherwise you can run it using application.properties or application.yml

//Profile
//TO activate differernt profile sample Dev properties file
//use below command on generated jar
// java -jar JARNAME --spring.profiles.active=dev
//To activate PROD profile use below command
//java -jar JARNAME --spring.profiles.active=prod

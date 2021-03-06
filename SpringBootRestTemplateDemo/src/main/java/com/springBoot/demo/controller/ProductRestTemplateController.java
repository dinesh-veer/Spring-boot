package com.springBoot.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springBoot.demo.model.Product;

@RestController
public class ProductRestTemplateController {

	@Autowired
	RestTemplate restTemplate;
	
	//to run this project need to run SpringBootRestExampleDemo initially
	@RequestMapping("/template/products")
	public String getProducts() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
		
		return restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET,entity,String.class).getBody();
	}
	
	
	@PostMapping(value="/template/product/")
	public String createProduct(@RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);
		
		return restTemplate.exchange("http://localhost:8080/add", HttpMethod.POST,entity, String.class).getBody();
	}
	
	@PutMapping(value= {"/template/update","/template/update/{id}"})
	public String updateProduct(@RequestBody Product product , @PathVariable(required=false) Integer id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<>(product,headers);
		if(id!=null)
			return restTemplate.exchange("http://localhost:8080/update/"+id, HttpMethod.PUT,entity,String.class).getBody();
		else
			return restTemplate.exchange("http://localhost:8080/update/", HttpMethod.PUT,entity,String.class).getBody();
		
	}
	
	@DeleteMapping(value="/template/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
		
		return restTemplate.exchange("http://localhost:8080/product/"+id, HttpMethod.DELETE,entity,String.class).getBody();
		
	}
	
}

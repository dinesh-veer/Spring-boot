package com.springBoot.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.springBoot.demo.model.Product;

@Service
public class ProductService {
public static Map<Integer, Product> productMap= new HashMap<>();
	
	static {
		Product productOne= new Product();
		productOne.setId(1);
		productOne.setName("MEAL");
		productMap.put(productOne.getId(), productOne);
		
		Product producttwo= new Product();
		producttwo.setId(2);
		producttwo.setName("TEST");
		productMap.put(producttwo.getId(), producttwo);
		
	}
	public Collection<Product> getAllProducts(){
		return productMap.values();
	}
	
	
}

package com.springBoot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.demo.model.Product;
import com.springBoot.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/products")
	public ResponseEntity<Object> getProduts(){
		return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	/**
	 * pass the data in postman in below format
	 * {
        "id": 1,
        "name": "MEAL"
    	}
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping(value="/add")
	public ResponseEntity<Object> createProduct(@RequestBody Product product){
		productService.addProduct(product);
		return new ResponseEntity<Object>("Product added successfully" , HttpStatus.CREATED);
	}
}

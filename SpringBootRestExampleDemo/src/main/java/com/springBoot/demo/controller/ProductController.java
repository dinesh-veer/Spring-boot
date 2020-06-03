package com.springBoot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.demo.exception.ProductNotFoundException;
import com.springBoot.demo.model.Product;
import com.springBoot.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/products")
	@CrossOrigin(origins = "http://localhost:8081")
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
	@CrossOrigin(origins = "http://localhost:8081")
	public ResponseEntity<Object> createProduct(@RequestBody Product product){
		productService.addProduct(product);
		return new ResponseEntity<Object>("Product added successfully" , HttpStatus.CREATED);
	}
	
	
	
	@PutMapping({"/update","/update/{id}"})
	public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable(required=false) Integer id){
		if(productService.updateProduct(product)==1)
			return new ResponseEntity<Object>("Product Updated successfully", HttpStatus.OK);
		else 
			throw new ProductNotFoundException();
		
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable Integer id){
		if(productService.deleteProduct(id))
			
			return new ResponseEntity<Object>("Product deleted successfully ",HttpStatus.ACCEPTED);
		else 
			throw new ProductNotFoundException();
	}
	
}

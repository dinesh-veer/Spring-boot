package com.springBoot.demo.service;

import java.util.Collection;

import com.springBoot.demo.model.Product;

public interface ProductService {

	public abstract Collection<Product> getAllProducts();

	Product addProduct(Product product);

	int updateProduct(Product product);

	boolean deleteProduct(Integer id);

}
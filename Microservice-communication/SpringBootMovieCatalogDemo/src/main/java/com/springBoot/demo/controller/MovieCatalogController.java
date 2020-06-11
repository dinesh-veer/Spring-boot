package com.springBoot.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.demo.model.Catalog;

@RestController
@RequestMapping(value="/api/")
public class MovieCatalogController {

	@RequestMapping(value="/movieCatalog/{userId}")
	public List<Catalog> getMovieCatalog(@PathVariable String userId){
		
		return Collections.singletonList(new Catalog("MIB", "Alien fight", 4));
	}
	
}

package com.springBoot.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.demo.model.Movie;

@RestController
@RequestMapping("/movies")
public class MoviesController {

	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable String movieId) {
		return new Movie(movieId, "Test");
	}
	
}

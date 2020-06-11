package com.springBoot.demo.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springBoot.demo.model.Catalog;
import com.springBoot.demo.model.Movie;
import com.springBoot.demo.model.Rating;
import com.springBoot.demo.model.UserRating;

@RestController
@RequestMapping(value="/api/")
public class MovieCatalogController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/movieCatalog/{userId}")
	public List<Catalog> getMovieCatalog(@PathVariable String userId){
		
		UserRating userRating = restTemplate.getForObject("http://rating-service/rating/users/"+userId, UserRating.class);
		
		
		
		return userRating.getUserRating().
				stream().
				map(
					rating->{
						Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
						return new Catalog(movie.getMovieName(), " Desc", rating.getRating());
					}
				).
				collect(Collectors.toList());
		
	}
	
}

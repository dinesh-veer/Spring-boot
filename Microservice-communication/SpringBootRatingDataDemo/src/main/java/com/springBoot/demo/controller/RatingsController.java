package com.springBoot.demo.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.demo.model.Rating;
import com.springBoot.demo.model.UserRating;

@RestController
@RequestMapping("/rating")
public class RatingsController {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating(movieId,4);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable String userId) {
		UserRating userRating = new UserRating();
		userRating.setUserRating(Arrays.asList(
					new Rating("101",5),
					new Rating("102",4)
				));
		
		return userRating;
	}
}

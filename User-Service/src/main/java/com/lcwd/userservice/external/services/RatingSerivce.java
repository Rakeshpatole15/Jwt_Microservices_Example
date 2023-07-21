package com.lcwd.userservice.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lcwd.userservice.entity.Ratings;

@FeignClient(name = "RATINGSERVICE")
@Service
public interface RatingSerivce {
	
	//Get 
	
	
	//Post
	@PostMapping("/ratings")
	public Ratings cretateRating(Ratings values);
	
	//Put
	@PutMapping("/ratings/{ratingId}")
    public Ratings updateRating(@PathVariable("ratingId") String ratingId ,Ratings ratings);
	
	//Delete
	@DeleteMapping("/ratings/{ratingId}")
	public void deletRating(@PathVariable String ratingId);
}

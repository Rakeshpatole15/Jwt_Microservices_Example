package com.lcwd.ratingservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lcwd.ratingservice.ratings.Rating;

@Service
public interface RatingService {
	
	//create
	Rating create(Rating rating);
	
	//get All Ratings
	List<Rating> getRatings();
	
	//Get all by UserId
	List<Rating> getRatingByUserId(String userId);
	
	//get All by hotel
    List<Rating> getRatingByHotelId(String hotelId);
	
}

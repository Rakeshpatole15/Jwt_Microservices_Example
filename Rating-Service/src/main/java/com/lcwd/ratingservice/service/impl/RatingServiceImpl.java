package com.lcwd.ratingservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.ratingservice.ratings.Rating;
import com.lcwd.ratingservice.repository.RatingRepository;
import com.lcwd.ratingservice.service.RatingService;


@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating create(Rating rating) {
		
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		
		return ratingRepository.findByHotelId(hotelId);
	}

}

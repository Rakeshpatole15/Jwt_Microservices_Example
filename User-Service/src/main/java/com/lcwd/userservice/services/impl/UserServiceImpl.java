package com.lcwd.userservice.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.userservice.entity.Hotel;
import com.lcwd.userservice.entity.Ratings;
import com.lcwd.userservice.entity.User;
import com.lcwd.userservice.exception.ResourceNotFoundException;
import com.lcwd.userservice.external.services.HotelService;
import com.lcwd.userservice.repositories.UserRepository;
import com.lcwd.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	
	
	private Logger logger= LoggerFactory.getLogger(UserService.class);

	@Override
	public User saveUser(User user) {	
		//genrat Uniqe user id
		
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}
    
	
	//Get All Uers 
	@Override
	public List<User> getAllUser() {
		List<User> user1= userRepository.findAll();
		
		for(User user: user1) {
			ArrayList<Ratings> ratingsOfUser=restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + user.getUserId(), ArrayList.class);
			logger.info("{} ", ratingsOfUser);
		
			user.setRatings(ratingsOfUser);
			
		}
		return user1;
		
	}
    
	 
	//Get Single User
	@Override
	public User getUser(String userId) {
		//Get User From Database with the help of userRepository
		User user= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found  on server ! :"+userId) );
		//Fetch Ratings Of the Above user from rating Service
		//http://localhost:8083/ratings/users/5abdff39-371e-408d-a3d6-968b79135857
		
		Ratings[] ratingsOfUser=restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + user.getUserId(), Ratings[	].class);
		logger.info("{} ", ratingsOfUser);
		List<Ratings> ratings=Arrays.stream(ratingsOfUser).toList();
		
		List<Ratings> ratingList = ratings.stream().map(rating ->{
			
			
			
			//http://localhost:8082/hotels/59a7b993-d71e-4ba5-bbc1-1a555073d73f
			
			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			
			//forEntity.getBody();
			Hotel hotel= hotelService.getHotel(rating.getHotelId());
					
			//logger.info("response status code: {} ", forEntity.getStatusCode());
			
			rating.setHotel(hotel);
			
	      return rating;
			
			
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		
		return user;
	}

}

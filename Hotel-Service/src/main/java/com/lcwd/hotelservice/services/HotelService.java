package com.lcwd.hotelservice.services;

import java.util.List;

import com.lcwd.hotelservice.entity.Hotel;

public interface HotelService {
	
	//create 
	
	Hotel create(Hotel hotel);
	
	//get All
	List<Hotel> getAll();
	
	//get Single
	Hotel get(String id);

}

package com.lcwd.hotelservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotelservice.entity.Hotel;
import com.lcwd.hotelservice.exception.ResourseNotFoundException;
import com.lcwd.hotelservice.repositories.HotelRepository;
import com.lcwd.hotelservice.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		String randomUID=UUID.randomUUID().toString();
		hotel.setId(randomUID);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		
		return hotelRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Hotel with given id not found !!"));
	}

}

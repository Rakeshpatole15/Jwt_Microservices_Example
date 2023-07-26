package com.lcwd.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.lcwd.hotelservice.entity.Hotel;
import com.lcwd.hotelservice.services.HotelService;

@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	//create 
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	} 
	
	//get single 
	@GetMapping("/{HotelId}")
	public ResponseEntity<Hotel> createHotel(@PathVariable String HotelId){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(HotelId));
	} 
	
	//get all 
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(){
		 return ResponseEntity.ok(hotelService.getAll());
	}

}

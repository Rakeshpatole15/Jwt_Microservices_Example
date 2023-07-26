package com.lcwd.hotelservice.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StaffController {
	
	@GetMapping
	public ResponseEntity<List<String>> getStaffs(){
		List<String> list = Arrays.asList("Ram", "Sham", "Sita", "Lakshman", "Krishna");
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}

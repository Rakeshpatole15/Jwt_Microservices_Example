package com.lcwd.hotelservice.exception;

public class ResourseNotFoundException extends RuntimeException {
	
	public ResourseNotFoundException(String s) {
		super(s);
	}
	
	public ResourseNotFoundException() {
		super("Resourse Not Found");
	}

}

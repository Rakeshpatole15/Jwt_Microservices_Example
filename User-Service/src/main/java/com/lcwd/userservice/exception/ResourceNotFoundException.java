package com.lcwd.userservice.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	//Extra Properties that want you manage`
	
	public ResourceNotFoundException() {
		super("Resource not found on server !!");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}

package com.lcwd.userservice.services;

import java.util.List;

import com.lcwd.userservice.entity.User;

public interface UserService {
	
	// perform user operation
	
	//create
	User saveUser(User user);
	
	//Get All User
	List<User> getAllUser();
	
	//Get Single User By give UserId
	User getUser(String userId);

}

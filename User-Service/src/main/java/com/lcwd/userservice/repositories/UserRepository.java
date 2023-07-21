package com.lcwd.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	//If you want to implement any custom method or query

}

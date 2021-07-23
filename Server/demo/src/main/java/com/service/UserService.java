package com.service;

import java.util.List;
import java.util.Optional;

import com.model.User;

public interface UserService {

	//This is the first instantiation of a method in our Service class. it is a List of the User model and contains a method called findAll()
	public List<User> findAll();
	
	//Optional is primarily intended for use as a method return type where there is a clear need to represent "no result," 
	//and where using null is likely to cause errors.
	//So if user is not found we don't want error where null might be a problem. 
	public Optional<User> findById(Long id);
	
	//Note that the parameter being passed is User. 
	public void addUser(User user);
	
}

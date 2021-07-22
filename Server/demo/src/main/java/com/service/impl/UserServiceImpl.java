package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.User;
import com.service.UserService;

//This needs to implement the User Service
//We need to tell Spring this is a ServiceImpl Class with the @Service annotation 
	//This tells Spring that under this class we will have business logic 
	//Business logic of the Service class goes under the ServiceImpl class

@Service
public class UserServiceImpl implements UserService{

	
	//This is the serviceImpl method that will find all Users. It was instantiated on the UserService interface.
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> usersList = new ArrayList<>();
		return usersList;
	}
	

}

package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

//We need to tell Spring this is a REST controller. Will be an entry point for client from Application
//This will be done with Spring annotations below 


@RestController
@RequestMapping("/api/users/")
public class UserController {
	
	//We need to inject the UserServiceImpl under the Controller Class using @Autowired
	//Spring knows behind the scenes that we want to use UserServiceImpl 
	
	@Autowired
	private UserService userService;
	
	//We also need to tell Spring which request to do on each method so that it knows
	
	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}

}

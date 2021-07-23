package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

//We need to tell Spring this is a REST controller. Will be an entry point for client from Application
//This will be done with Spring annotations below 


@RestController
@RequestMapping("/api/users") //Removed the / at end of users/. It is important for separate mapping. 
public class UserController {
	
	//We need to inject the UserServiceImpl under the Controller Class using @Autowired
	//Spring knows behind the scenes that we want to use UserServiceImpl 
	
	@Autowired
	private UserService userService;
	
	//We also need to tell Spring which request to do on each method so that it knows how to Map.
	
	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}
	
	//This one will have the Optional class within the method. This is a GetMapping annotation as another get to grab data
	//Notice this GetMapping has the id as the next / in the path. You can isolate by ids now with that 
	//This also needs the annotation @PathVariable, this will allow Spring to know which variable to grab 
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		Optional<User> userOption = userService.findById(id);
	
			if (userOption.isPresent()) {
				return userOption.get();
			}
		
		return null;
	}
	
	
	
	
}

package com.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<?> findAll() {
		List<User> findAllUsers = userService.findAll();
		
		return new ResponseEntity<List<User>>(findAllUsers, HttpStatus.OK);
	}
	
	//This one will have the Optional class within the method. This is a GetMapping annotation as another get to grab data
	//Notice this GetMapping has the id as the next / in the path. You can isolate by ids now with that 
	//This also needs the annotation @PathVariable, this will allow Spring to know which variable to grab 
	
	//ResponseEntity is a Springboot import
	//Originally we had a different method but ResponseEntity will allow us greater control over HttpStatuses
	//Remember this in class, We used the REsponseEntity to get HTTP status codes. Will throw us 200 and 404 errors now. 
	//It is also a ? in the method call because that way we can use <User> and <Void> inside the method
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@Valid @PathVariable Long id) {
		Optional<User> userOption = userService.findById(id);
	
			if (userOption.isPresent()) {
				return new ResponseEntity<User>(userOption.get(), HttpStatus.OK);
			}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	//PostMapping is needed when we create something new for the API to grab. 
	//We will need RequestBody, This helps Spring be able to interpret the User Model
	//Need @Valid Annotation, this will allow spring to verify the User on the request. This works when we have instance variables on our model that are NOT NULL. 
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User user){
		userService.addUser(user);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
}

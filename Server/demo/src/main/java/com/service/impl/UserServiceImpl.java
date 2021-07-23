package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.model.User;
import com.service.UserService;

//This needs to implement the User Service
//We need to tell Spring this is a ServiceImpl Class with the @Service annotation 
	//This tells Spring that under this class we will have business logic 
	//Business logic of the Service class goes under the ServiceImpl class

@Service
public class UserServiceImpl implements UserService{
	
	//An empty List of Users currently. Needs to be static because it will then be populated on initialiazation. 
	public static List<User> usersList = new ArrayList<>();
	
	//We want to control the id to increment on each user.
	//This is an Long, we can use it on a User in the static variables below because the first requirement is an id that is an Long
	private static Long COUNTER = 1l;
	
	static {
		User user = new User(COUNTER++, "Chris", "Kalama", 25, "USA");
		usersList.add(user);
		
		user = new User(COUNTER++, "Sally", "Margie", 39, "Brazil");
		usersList.add(user);
		
		user = new User(COUNTER++, "Jax", "Teller", 29, "USA");
		usersList.add(user);
		
		user = new User(COUNTER++, "Becky", "Fuller", 22, "Canada");
		usersList.add(user);
		
		user = new User(COUNTER++, "Kelly", "Rhodes", 30, "Russia");
		usersList.add(user);
	}

	
	//This is the serviceImpl method that will find all Users. It was instantiated on the UserService interface.
	@Override
	public List<User> findAll() {
		return usersList;
	}
	
	//serviceImpl method that will be Users by Id. It was instantiated on the UserService interface.
	@Override
	public Optional<User> findById(Long id) {
			Optional<User> userOption = usersList.stream().filter(user -> user.getId() == id).findFirst();
			
				return userOption;
			//You can re-factor this further and just put the return before the Optional...
		
	}
	

}

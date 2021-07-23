package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	
	//serviceImpl to addUsers and PostMap, You will need to also take care of the Id
	@Override
	public void addUser(User user) {
		//Need to make sure the ID is incrementing. 
		user.setId(COUNTER++);
		//This will add a new User passed through the parameter into the Array List usersList
		usersList.add(user);
		
	}

	//serviceImpl to deleteUsers
	@Override
	public Optional<User> deleteUser(Long id){
		//Need to verify first if User is in the ArrayList by checking its ID. The Stream and filter are looking for the user Id
		Optional<User> userOption = usersList.stream().filter(user -> user.getId() == id).findFirst();
		
		if(userOption.isPresent()) {
			//We are going to need another stream process and filter out the Ids. This will collect the statements as a List.
			//With this, we are using a != to signify find all the users that AREN'T Being given the Id asked for. 
			usersList = usersList.stream().filter(user -> 
						userOption.get().getId() != user.getId()).collect(Collectors.toList());
			
			
			return userOption;
		}
		
		//Optionals can be empty like this with this Java method. 
		return Optional.empty();
	}
}

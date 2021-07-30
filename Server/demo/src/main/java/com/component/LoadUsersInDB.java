package com.component;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.model.User;
import com.repository.UserRepository;

@Component
@Transactional
public class LoadUsersInDB implements CommandLineRunner{
	
	//We need to inject the Repository
	@Autowired
	private UserRepository userRepository; 

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User("Chris", "Kalama", 25, "USA");
		
		User user2 = new User( "Sally", "Margie", 39, "Brazil");
		
		User user3 = new User("Jax", "Teller", 29, "USA");
		
		User user4 = new User("Becky", "Fuller", 22, "Canada");
		
		User user5 = new User("Kelly", "Rhodes", 30, "Russia");
		
		User user6 = new User("Matt", "Holland", 45, "Mexico");
		
		User user7 = new User("Ryan", "Manny", 21, "USA");

		List<User> usersList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7);
		
		userRepository.saveAll(usersList);
	}

}

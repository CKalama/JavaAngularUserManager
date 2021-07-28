package com.component;

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
		
		User user = new User("Chris", "Kalama", 25, "USA");
		userRepository.save(user);
		
		user = new User( "Sally", "Margie", 39, "Brazil");
		userRepository.save(user);
		
		user = new User("Jax", "Teller", 29, "USA");
		userRepository.save(user);
		
		user = new User("Becky", "Fuller", 22, "Canada");
		userRepository.save(user);
		
		user = new User("Kelly", "Rhodes", 30, "Russia");
		userRepository.save(user);

	}

}

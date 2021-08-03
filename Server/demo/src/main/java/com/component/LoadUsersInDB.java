package com.component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
		
		User user1 = new User("chrisK", UUID.randomUUID().toString(),"Chris", "Kalama", 25, "USA");
		
		User user2 = new User("sallyM", UUID.randomUUID().toString(), "Sally", "Margie", 39, "Brazil");
		
		User user3 = new User("jaxT", UUID.randomUUID().toString(),"Jax", "Teller", 29, "USA");
		
		User user4 = new User("beckyF", UUID.randomUUID().toString(),"Becky", "Fuller", 22, "Canada");
		
		User user5 = new User("kellyR", UUID.randomUUID().toString(),"Kelly", "Rhodes", 30, "Russia");
		
		User user6 = new User("mattH", UUID.randomUUID().toString(),"Matt", "Holland", 45, "Mexico");
		
		User user7 = new User("ryanM", UUID.randomUUID().toString(),"Ryan", "Manny", 21, "USA");

		List<User> usersList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7);
		
		userRepository.saveAll(usersList);
	}

}

package com.freshvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.freshvotes.domain.User;
import com.freshvotes.respositories.UserRepository;
import com.freshvotes.security.Authority;

//This will be a service that talks to the DB whenever we create a new User
@Service
public class UserService {
	//Here we call into the context of spring 
	//The repo we have created previously
	//So that the instance of the object gets created
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//Now we uuse the repo to store the user we create when registering
	public User saveUser(User user) {
		//Here we are encoding the password, because if we do not do so, then
		//User will come with the password not encoded, and the webSecurityConfiguration
		//Wont let him access as there's specified that password must be encoded
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		//Here we create the authority, and the user assigned to this authority
		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setUser(user);
		//As this is a bidirectional relation, we need to set the authority in the user as well
		user.getAuthorities().add(authority);
		
		return userRepo.save(user);

	}
}

package com.freshvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.freshvotes.domain.User;
import com.freshvotes.respositories.UserRepository;
import com.freshvotes.security.customSecurityUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username and password");
		}
		return new customSecurityUser(user);
		
	}

}

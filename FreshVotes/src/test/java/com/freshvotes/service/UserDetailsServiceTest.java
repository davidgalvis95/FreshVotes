package com.freshvotes.service;

import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.not;
import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;

import static org.hamcrest.CoreMatchers.not;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class UserDetailsServiceTest {
	
	//This test is to test the encrypted password
	@Test
	void generateEncryptedPassword() {
		//fail("Not yet implemented");
		BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
		String rawPassword = "password";
		String rawPassword1 = "password";
		String enc = "$2a$10$PC0Yz4Veq9DAO1B95oanH.ru51TaQostXSWIoIYyspz/VbvsTyEg2";
		String encodedPassword = encoder.encode(rawPassword);
		assertNotEquals(rawPassword,encodedPassword);
		assertEquals(rawPassword,rawPassword1);
		//assertEquals(enc,encodedPassword);
		System.out.println(encodedPassword);
		//Assert(rawPassword,CoreMatchers.not(encodedPassword));
	}

}

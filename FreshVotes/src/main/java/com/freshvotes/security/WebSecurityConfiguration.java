package com.freshvotes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfiguration 
extends WebSecurityConfigurerAdapter{
	
	//This password encoder enables to encrypt the 
	//password, if there is not that, then spring will throw an error
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.passwordEncoder(getPasswordEncoder())
		.withUser("davidsand95@outlook.com")
		.password(getPasswordEncoder().encode("password"))
		.roles("USER");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//This method states that once we have said who are we
		//We should tell what kind of permissions do we need or we have
		
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		.anyRequest().hasRole("USER").and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/dashboard")
			.permitAll()
			.and()
		.logout()
			.logoutUrl("/logout")
			.permitAll();
		
		//The permitAll authorization just says like let everyone get in
		//And by specifying the "/", what we say is that everyone can see the
		//homepage
	}
}

package com.freshvotes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	// This password encoder enables to encrypt the
	// password, if there is not that, then spring will throw an error
	//As we have set this PasswordEncoder as a bean, we can use it in the spring context
	//So we can call it using the Autowired annotation
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication().passwordEncoder(getPasswordEncoder()).withUser(
		 * "davidsand95@outlook.com")
		 * .password(getPasswordEncoder().encode("password")).roles("USER");
		 */

		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// This method states that once we have said who are we
		// We should tell what kind of permissions do we need or we have
		// Cross Site Forgery Token is a random number that allo us to be protected when
		// Somebody tries to pretend to be us or make something in our behalf
		// Inside a portal session

		// http.csrf().disable()
		// We enable CSRF by removing the disable code
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/register").permitAll().antMatchers("/login").permitAll().antMatchers("/admin/**")
				.hasRole("ADMIN").anyRequest().hasRole("USER").and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/dashboard").permitAll().and().logout().logoutUrl("/logout").permitAll();

		// The permitAll authorization just says like let everyone get in
		// And by specifying the "/", what we say is that everyone can see the
		// homepage
	}
}

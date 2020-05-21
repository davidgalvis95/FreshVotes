package com.freshvotes.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import com.freshvotes.domain.User;

//This authority should be an entity because we are storing this information on a DB
//These are the authorities that are given to the user, it means the role he/she has
@Entity
public class Authority implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6180472730078286755L;
	
	private Long Id;
	private String authority;
	private User user;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	@ManyToOne()
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}

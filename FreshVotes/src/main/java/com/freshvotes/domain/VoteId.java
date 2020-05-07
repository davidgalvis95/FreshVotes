package com.freshvotes.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class VoteId implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6202269445639364170L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 6202269445639364170L;
	private User user;
	private Feature feature;
	//This relationship is many to one because the relationship from 
	//Users to Votes is one to many, hence the relationship from 
	//votes to users is many to one
	//The same logic works for the feature
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	public Feature getFeature() {
		return feature;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
}

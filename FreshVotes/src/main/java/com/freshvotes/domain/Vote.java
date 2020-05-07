package com.freshvotes.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Vote {
	//here we will use the user and the feature ids as
	//the composite keys, they are an embeded one
	
	
	private VoteId pk;
	private boolean upvote;
	
	//Here we use the embedded and embeddable annotations in order
	//To split the table that connects with the User an feature
	//Also to reuse come of the code
	@EmbeddedId
	public VoteId getPk() {
		return pk;
	}

	public void setPk(VoteId pk) {
		this.pk = pk;
	}



	public boolean isUpvote() {
		return upvote;
	}

	public void setUpvote(boolean upvote) {
		this.upvote = upvote;
	}
	
}

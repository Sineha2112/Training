package com.chain.model;

public class CastingVote {
	private Integer userId;
	private String partyName;
	private String vote;
	
	//default constructor
	public CastingVote() {
		
	}
	
	//parameterized constructor
	public CastingVote(Integer userId, String partyName, String vote) {
		super();
		this.userId = userId;
		this.partyName = partyName;
		this.vote = vote;
	}

	//getters & setters
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	//toString
	@Override
	public String toString() {
		return "CastingVote [userId=" + userId + ", partyName=" + partyName + ", vote="
				+ vote + "]";
	}
	
	
}

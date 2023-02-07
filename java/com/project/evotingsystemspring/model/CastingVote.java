package com.project.evotingsystemspring.model;

public class CastingVote {
	private String electionType;
	private Integer userId;
	private String partyName;
	private String vote;
	
	//default constructor
	public CastingVote() {
		super();
		
	}
	
	
	//parameterized constructor
	public CastingVote(String electionType, Integer userId, String partyName, String vote) {
		super();
		this.electionType = electionType;
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

	
	public String getElectionType() {
		return electionType;
	}


	public void setElectionType(String electionType) {
		this.electionType = electionType;
	}


	//toString
	@Override
	public String toString() {
		return "CastingVote [electionType=" + electionType + ", userId=" + userId + ", partyName=" + partyName
				+ ", vote=" + vote + "]";
	}


	
	
}

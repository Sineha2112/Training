package com.project.evotingsystemspring.model;

public class CastingVote {
	private String electionType;
	private String voterId;
	private String partyName;
	private String vote;
	
	//default constructor
	public CastingVote() {
		super();
	}
	
	//parameterized constructor
	public CastingVote(String electionType, String voterId, String partyName, String vote) {
		super();
		this.electionType = electionType;
		this.voterId = voterId;
		this.partyName = partyName;
		this.vote = vote;
	}
	
	//getters & setters
	

	public String getPartyName() {
		return partyName;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
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
		return "CastingVote [electionType=" + electionType + ", voterId=" + voterId + ", partyName=" + partyName
				+ ", vote=" + vote + "]";
	}


	

	
	
}

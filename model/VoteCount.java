package com.project.evotingsystemspring.model;

public class VoteCount {
	private String partyName;
	private Integer count;
	
	//default constructor
	public VoteCount() {
		super();
		
	}
	
	//parameterized constructor
	public VoteCount(String partyName, Integer count) {
		super();
		this.partyName = partyName;
		this.count = count;
	}
	
	//getters & Setters
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	//toString
	@Override
	public String toString() {
		return "VoteCount [partyName=" + partyName + ", count=" + count + "]";
	}
	
}

package com.project.evotingsystemspring.model;

import java.sql.Date;


public class NRIVoter {
	//data members for NRIVoter class
		private Integer nriId;
		private String nriVoterName;
		private Date nriDateOfBirth;
		private Integer nriAge;
		private String nriVoterId;
		private String nriFatherName;
		private String nriGender;
		private String nriNationality;
		private String nriAddress;
		private String nriCity;
		private String nriEmailId;
		private String nUserPassword;
		private String partyName;
		private String vote;
		private String nriNewPassword;
		
		//default constructor
		public NRIVoter() {
			super();
			
		}

		
		//parameterized constructor
		public NRIVoter(Integer nriId, String nriVoterName, Date nriDateOfBirth, Integer nriAge, String nriVoterId,
				String nriFatherName, String nriGender) {
			super();
			this.nriId = nriId;
			this.nriVoterName = nriVoterName;
			this.nriDateOfBirth = nriDateOfBirth;
			this.nriAge = nriAge;
			this.nriVoterId = nriVoterId;
			this.nriFatherName = nriFatherName;
			this.nriGender = nriGender;
		}

		public NRIVoter(String nriNationality, String nriAddress, String nriCity, String nriEmailId,
				String nUserPassword) {
			super();
			this.nriNationality = nriNationality;
			this.nriAddress = nriAddress;
			this.nriCity = nriCity;
			this.nriEmailId = nriEmailId;
			this.nUserPassword = nUserPassword;
		}

		
		//gettters setters
		public Integer getNriId() {
			return nriId;
		}

		public void setNriId(Integer nriId) {
			this.nriId = nriId;
		}

		public String getNriVoterName() {
			return nriVoterName;
		}

		public void setNriVoterName(String nriVoterName) {
			this.nriVoterName = nriVoterName;
		}

		public Date getNriDateOfBirth() {
			return nriDateOfBirth;
		}

		public void setNriDateOfBirth(Date nriDateOfBirth) {
			this.nriDateOfBirth = nriDateOfBirth;
		}

		public Integer getNriAge() {
			return nriAge;
		}

		public void setNriAge(Integer nriAge) {
			this.nriAge = nriAge;
		}

		public String getNriVoterId() {
			return nriVoterId;
		}

		public void setNriVoterId(String nriVoterId) {
			this.nriVoterId = nriVoterId;
		}

		public String getNriFatherName() {
			return nriFatherName;
		}

		public void setNriFatherName(String nriFatherName) {
			this.nriFatherName = nriFatherName;
		}

		public String getNriGender() {
			return nriGender;
		}

		public void setNriGender(String nriGender) {
			this.nriGender = nriGender;
		}

		public String getNriNationality() {
			return nriNationality;
		}

		public void setNriNationality(String nriNationality) {
			this.nriNationality = nriNationality;
		}

		public String getNriAddress() {
			return nriAddress;
		}


		public void setNriAddress(String nriAddress) {
			this.nriAddress = nriAddress;
		}


		public String getNriCity() {
			return nriCity;
		}

		public void setNriCity(String nriCity) {
			this.nriCity = nriCity;
		}

		public String getNriEmailId() {
			return nriEmailId;
		}

		public void setNriEmailId(String nriEmailId) {
			this.nriEmailId = nriEmailId;
		}

		public String getnUserPassword() {
			return nUserPassword;
		}

		public void setnUserPassword(String nUserPassword) {
			this.nUserPassword = nUserPassword;
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
		

		public String getNriNewPassword() {
			return nriNewPassword;
		}


		public void setNriNewPassword(String nriNewPassword) {
			this.nriNewPassword = nriNewPassword;
		}


		public void setVote(String vote) {
			this.vote = vote;
		}


		//toString
		@Override
		public String toString() {
			return "NRIVoter [nriId=" + nriId + ", nriVoterName=" + nriVoterName + ", nriDateOfBirth=" + nriDateOfBirth
					+ ", nriAge=" + nriAge + ", nriVoterId=" + nriVoterId + ", nriFatherName=" + nriFatherName
					+ ", nriGender=" + nriGender + ", nriNationality=" + nriNationality + ", nriAddress=" + nriAddress
					+ ", nriCity=" + nriCity + ", nriEmailId=" + nriEmailId + ", nUserPassword=" + nUserPassword + "]";
		}
		
		
		
}		
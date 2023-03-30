package com.project.evotingsystemspring.model;

import java.sql.Date;


public class Admin {
	//data members of admin class
		private String adminId;
		private String password;
		private String adminName;
		private String adminEmailId;
		private String role;
		private Integer count;
		private Integer electionId;
		private String electionName;
		private Date electionDate;
		private Integer assetValue;
		private Integer pastAssetValue;
		private String candidateName;
		private String partyName;
		private String reportOfCandidate;
		
		//default constructor
		public Admin() {
			super();
		}

		
		//parameterized constructor
		public Admin(String adminId, String password, String adminName, String adminEmailId) {
			super();
			this.adminId = adminId;
			this.password = password;
			this.adminName = adminName;
			this.adminEmailId = adminEmailId;
		}


		//getters & setters

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getAdminId() {
			return adminId;
		}

		public void setAdminId(String adminId) {
			this.adminId = adminId;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			 this.count = count;
		}

		public Integer getElectionId() {
			return electionId;
		}

		public void setElectionId(Integer electionId) {
			this.electionId = electionId;
		}

		public String getElectionName() {
			return electionName;
		}

		public void setElectionName(String electionType) {
			this.electionName = electionType;
		}

		public Date getElectionDate() {
			return electionDate;
		}

		public void setElectionDate(Date electionDate) {
			this.electionDate = electionDate;
		}

		
		public String getAdminName() {
			return adminName;
		}


		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}


		public String getAdminEmailId() {
			return adminEmailId;
		}


		public void setAdminEmailId(String adminEmailId) {
			this.adminEmailId = adminEmailId;
		}

		public Integer getAssetValue() {
			return assetValue;
		}


		public void setAssetValue(Integer assetValue) {
			this.assetValue = assetValue;
		}


		public Integer getPastAssetValue() {
			return pastAssetValue;
		}


		public void setPastAssetValue(Integer pastAssetValue) {
			this.pastAssetValue = pastAssetValue;
		}
		
		public String getCandidateName() {
			return candidateName;
		}


		public void setCandidateName(String candidateName) {
			this.candidateName = candidateName;
		}


		public String getPartyName() {
			return partyName;
		}


		public void setPartyName(String partyName) {
			this.partyName = partyName;
		}


		public String getReportOfCandidate() {
			return reportOfCandidate;
		}


		public void setReportOfCandidate(String reportOfCandidate) {
			this.reportOfCandidate = reportOfCandidate;
		}


		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", password=" + password + ", adminName=" + adminName
					+ ", adminEmailId=" + adminEmailId + ", role=" + role + ", count=" + count + ", electionId="
					+ electionId + ", electionName=" + electionName + ", electionDate=" + electionDate + ", assetValue="
					+ assetValue + ", pastAssetValue=" + pastAssetValue 
					+ ", reportOfCandidate=" + reportOfCandidate + "]";
		}


		//toString
	

	

		
		
		
}

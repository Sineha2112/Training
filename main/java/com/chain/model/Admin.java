package com.chain.model;

public class Admin {
	//data members of admin class
		private String adminId;
		private String password;
		private String role;
		private Integer count;
		private Integer electionId;
		private String electionName;
		private String electionDate;
		
		//default constructor
		public Admin() {
			
		}
		
		//parameterized constructor
		public Admin(String adminId, String password) {
			super();
			this.adminId = adminId;
			this.password = password;
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

		public String getElectionDate() {
			return electionDate;
		}

		public void setElectionDate(String electionDate) {
			this.electionDate = electionDate;
		}

		//toString
		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", password=" + password + "]";
		}

		
		
		
}

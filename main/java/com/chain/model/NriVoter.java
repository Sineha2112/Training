package com.chain.model;

public class NriVoter {
	//data members for NRIVoter class
		private Integer nriId;
		private String voterName;
		private String dateOfBirth;
		private Integer age;
		private String voterId;
		private String fatherName;
		private String gender;
		private String nationality;
		private String state;
		private String city;
		private String emailId;
		private String userPassword;
		
		//default constructor
		public NriVoter() {
		
			
		}

		//parameterized constructor
		public NriVoter(Integer nriId, String voterName, String dateOfBirth, Integer age, String voterId, String fatherName,
				String gender,String nationality, String state,String city,String emailId, String userPassword) {
			super();
			this.nriId = nriId;
			this.voterName = voterName;
			this.dateOfBirth = dateOfBirth;
			this.age = age;
			this.voterId = voterId;
			this.fatherName = fatherName;
			this.gender = gender;
			this.nationality = nationality;
			this.state = state;
			this.city = city;
			this.emailId = emailId;
			this.userPassword = userPassword;
		}

		//getters & setters
		public Integer getNriId() {
			return nriId;
		}

		public void setNriId(Integer nriId) {
			this.nriId = nriId;
		}

		public String getVoterName() {
			return voterName;
		}

		public String setVoterName(String voterName) {
			return this.voterName = voterName;
		}

		public String getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getVoterId() {
			return voterId;
		}

		public String setVoterId(String voterId) {
			return this.voterId = voterId;
		}

		public String getFatherName() {
			return fatherName;
		}

		public String setFatherName(String fatherName) {
			return this.fatherName = fatherName;
		}

		public String getGender() {
			return gender;
		}

		public String setGender(String gender) {
			return this.gender = gender;
		}

		public String getCity() {
			return city;
		}

		public String setCity(String city) {
			return this.city = city;
		}

		public String getState() {
			return state;
		}

		public String setState(String state) {
			return this.state = state;
		}

		public String getNationality() {
			return nationality;
		}

		public String setNationality(String nationality) {
			return this.nationality = nationality;
		}

		public String getEmailId() {
			return emailId;
		}

		public String setEmailId(String emailId) {
			return this.emailId = emailId;
		}

		public String getUserPassword() {
			return userPassword;
		}

		public String setUserPassword(String userPassword) {
			return this.userPassword = userPassword;
		}

		//toString
		@Override
		public String toString() {
			return "NRIVoter [nriId=" + nriId + ", voterName=" + voterName + ", dateOfBirth=" + dateOfBirth + ", age=" + age
					+ ", voterId=" + voterId + ", fatherName=" + fatherName + ", gender=" + gender + ", nationality="
					+ nationality + ", state=" + state + ", city=" + city + ", emailId=" + emailId + ", userPassword="
					+ userPassword + "]";
		}
}

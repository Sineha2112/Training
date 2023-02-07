package com.project.evotingsystemspring.model;

import java.sql.Date;

public class Voter {
	//data members of voter class
		private Integer userId;
		private String voterName;
		private Date dateOfBirth;
		private Integer age;
		private String voterId;
		private String fatherName;
		private String gender;
		private String address;
		private String city;
		private String nationality;
		private Long mobileNumber;
		private String emailId;
		private String userPassword;
		private String changeData;
		private String updateData;
		private String vote;
		private String voterType;
		private Integer count;
		private String complaints;
		private String feedback;
		private String partyName;
		
		//Default constructor
		public Voter() {
			
		}

		//parameterized constructor
		public Voter(Integer userId, String voterName, Date dateOfBirth, Integer age, String voterId, String fatherName,
				String gender, String address, String city, String nationality, Long mobileNumber, String emailId,
				String userPassword) {
			super();
			this.userId = userId;
			this.voterName = voterName;
			this.dateOfBirth = dateOfBirth;
			this.age = age;
			this.voterId = voterId;
			this.fatherName = fatherName;
			this.gender = gender;
			this.address = address;
			this.city = city;
			this.nationality = nationality;
			this.mobileNumber = mobileNumber;
			this.emailId = emailId;
			this.userPassword = userPassword;
		}

		//getters & setters
		public Integer getUserId() {
			return userId;
		}

		public Integer setUserId(Integer userId) {
			return this.userId = userId;
		}

		public String getVoterName() {
			return voterName;
		}

		public String setVoterName(String voterName) {
			return this.voterName = voterName;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public Date setDateOfBirth(Date dateOfBirth) {
			return this.dateOfBirth = dateOfBirth;
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

		public String getAddress() {
			return address;
		}

		public String setAddress(String address) {
			return this.address = address;
		}

		public String getCity() {
			return city;
		}

		public String setCity(String city) {
			return this.city = city;
		}

		public String getNationality() {
			return nationality;
		}

		public String setNationality(String nationality) {
			return this.nationality = nationality;
		}

		public Long getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(Long mobileNumber) {
			this.mobileNumber = mobileNumber;
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

		public String getChangeData() {
			return changeData;
		}

		public void setChangeData(String changeData) {
			this.changeData = changeData;
		}

		public String getUpdateData() {
			return updateData;
		}

		public void setUpdateData(String updateData) {
			this.updateData = updateData;
		}
		public String getVote() {
			return vote;
		}

		public void setVote(String vote) {
			this.vote = vote;
		}

		public String getVoterType() {
			return voterType;
		}

		public void setVoterType(String voterType) {
			this.voterType = voterType;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public String getComplaints() {
			return complaints;
		}

		public void setComplaints(String complaints) {
			this.complaints = complaints;
		}
		

		public String getFeedback() {
			return feedback;
		}

		public void setFeedback(String feedback) {
			this.feedback = feedback;
		}
		

		public String getPartyName() {
			return partyName;
		}

		public void setPartyName(String partyName) {
			this.partyName = partyName;
		}

		//toString
		@Override
		public String toString() {
			return "Voter [userId=" + userId + ", voterName=" + voterName + ", dateOfBirth=" + dateOfBirth + ", age=" + age
					+ ", voterId=" + voterId + ", fatherName=" + fatherName + ", gender=" + gender + ", address=" + address
					+ ", city=" + city + ", nationality=" + nationality + ", mobileNumber=" + mobileNumber + ", emailId="
					+ emailId + ", userPassword=" + userPassword + "]";
		}
		
}

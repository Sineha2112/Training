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
		private Integer count;
		private String complaints;
		private String feedback;
		private Integer rate;
		private String partyName;
		private String newPassword;
		
		//Default constructor
		public Voter() {
			super();
		}


		//parameterized constructor
		public Voter(String voterId, String address,String city, String nationality, Long mobileNumber, String emailId,
				String userPassword) {
			super();
			this.voterId = voterId;
			this.address = address;
			this.city = city;
			this.nationality = nationality;
			this.mobileNumber = mobileNumber;
			this.emailId = emailId;
			this.userPassword = userPassword;
		}

		public Voter(Integer userId, String voterName, Date dateOfBirth, Integer age, String fatherName, String gender,String emailId) {
			super();
			this.userId = userId;
			this.voterName = voterName;
			this.dateOfBirth = dateOfBirth;
			this.age = age;
			this.fatherName = fatherName;
			this.gender = gender;			
			this.emailId = emailId;
		}

		//getters & setters
		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			 this.userId = userId;
		}

		public String getVoterName() {
			return voterName;
		}

		public void setVoterName(String voterName) {
			 this.voterName = voterName;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
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

		public void setVoterId(String voterId) {
			 this.voterId = voterId;
		}

		public String getFatherName() {
			return fatherName;
		}

		public void setFatherName(String fatherName) {
			 this.fatherName = fatherName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			 this.gender = gender;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			 this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			 this.city = city;
		}

		public String getNationality() {
			return nationality;
		}

		public void setNationality(String nationality) {
			 this.nationality = nationality;
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

		public void setEmailId(String emailId) {
			 this.emailId = emailId;
		}

		public String getUserPassword() {
			return userPassword;
		}

		public void setUserPassword(String userPassword) {
			 this.userPassword = userPassword;
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

		public Integer getRate() {
			return rate;
		}

		public void setRate(Integer rate) {
			this.rate = rate;
		}

		public String getNewPassword() {
			return newPassword;
		}


		public void setNewPassword(String newPassword) {
			this.newPassword = newPassword;
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

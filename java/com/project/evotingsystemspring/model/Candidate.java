package com.project.evotingsystemspring.model;

public class Candidate {
	//data members of candidate class
		private Integer electionId;
		private Integer candidateId;
		private String partyName;
		private String partySymbol;
		private String candidateName;
		private String gender;
		private Integer age;
		private String address;
		private String city;
		private String nationality;
		private Long mobileNo;
		private String emailId;
		private String history;
		private String data;
		
		//default constructor
		public Candidate() {
			super();
			
		}

		//parameterized constructor
		public Candidate(Integer candidateId, String partyName, String partySymbol, String candidateName, String gender,
				Integer age, String address, String city, String nationality,Long mobileNo, String emailId,
				String history,Integer electionId) {
			super();
			this.candidateId = candidateId;
			this.partyName = partyName;
			this.partySymbol = partySymbol;
			this.candidateName = candidateName;
			this.gender = gender;
			this.age = age;
			this.address = address;
			this.city = city;
			this.nationality = nationality;
			this.mobileNo = mobileNo;
			this.emailId = emailId;
			this.history = history;
		}

		//getters & setters
		public Integer getCandidateId() {
			return candidateId;
		}

		public void setCandidateId(Integer candidateId) {
			this.candidateId = candidateId;
		}

		public String getPartyName() {
			return partyName;
		}

		public void setPartyName(String partyName) {
			this.partyName = partyName;
		}

		public String getPartySymbol() {
			return partySymbol;
		}

		public void setPartySymbol(String partySymbol) {
			this.partySymbol = partySymbol;
		}

		public String getCandidateName() {
			return candidateName;
		}

		public void setCandidateName(String candidateName) {
			this.candidateName = candidateName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
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

		public Long getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(Long mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getHistory() {
			return history;
		}

		public void setHistory(String history) {
			this.history = history;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Integer getElectionId() {
			return electionId;
		}

		public void setElectionId(Integer electionId) {
			this.electionId = electionId;
		}

		//toString
		@Override
		public String toString() {
			return "Candidate [electionId=" + " candidateId=" + candidateId + ", partyName=" + partyName + ", partySymbol=" + partySymbol
					+ ", candidateName=" + candidateName + ", gender=" + gender + ", age=" + age + ", address=" + address
					+ ", city=" + city + ", nationality=" + nationality + ", mobileNo=" + mobileNo + ", emailId=" + emailId
					+ ", history=" + history + "]";
		}

}

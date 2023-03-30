package com.project.evotingsystemspring.model;


import java.util.Arrays;


public class Candidate {
	//data members of candidate class
		private Integer electionId;
		private Integer candidateId;
		private String candidatePartyName;
		private String candidatePartySymbol;
		private String candidateName;
		private String candidateGender;
		private Integer candidateAge;
		private String candidateAddress;
		private String candidateCity;
		private String candidateNationality;
		private Long candidateMobileNo;
		private String candidateEmailId;
		private String history;
		private String data;
		private String criminalCase;
		private Integer yearsOfPunishment;
		private Integer releasedYear;
		private byte[] candidateImage;
		private byte[] symbolImage;
		private String imgPath;
		private String imgPath1;
		
		
		//default constructor
		public Candidate() {
			super();
		}


		//parameterized constructor
		public Candidate(Integer electionId, Integer candidateId, String candidatePartyName,
				String candidatePartySymbol, String candidateName, String candidateGender, Integer candidateAge) {
			super();
			this.electionId = electionId;
			this.candidateId = candidateId;
			this.candidatePartyName = candidatePartyName;
			this.candidatePartySymbol = candidatePartySymbol;
			this.candidateName = candidateName;
			this.candidateGender = candidateGender;
			this.candidateAge = candidateAge;
		}


		public Candidate(String candidateAddress, String candidateCity, String candidateNationality,
				Long candidateMobileNo, String candidateEmailId, String history, String data) {
			super();
			this.candidateAddress = candidateAddress;
			this.candidateCity = candidateCity;
			this.candidateNationality = candidateNationality;
			this.candidateMobileNo = candidateMobileNo;
			this.candidateEmailId = candidateEmailId;
			this.history = history;
			this.data = data;
		}


		public Candidate(String criminalCase, Integer yearsOfPunishment, Integer releasedYear, byte[] candidateImage,
				byte[] symbolImage, String imgPath, String imgPath1) {
			super();
			this.criminalCase = criminalCase;
			this.yearsOfPunishment = yearsOfPunishment;
			this.releasedYear = releasedYear;
			this.candidateImage = candidateImage;
			this.symbolImage = symbolImage;
			this.imgPath = imgPath;
			this.imgPath1 = imgPath1;
		}

		
		//getters setters
		public Integer getElectionId() {
			return electionId;
		}


		public void setElectionId(Integer electionId) {
			this.electionId = electionId;
		}


		public Integer getCandidateId() {
			return candidateId;
		}


		public void setCandidateId(Integer candidateId) {
			this.candidateId = candidateId;
		}


		public String getCandidatePartyName() {
			return candidatePartyName;
		}


		public void setCandidatePartyName(String candidatePartyName) {
			this.candidatePartyName = candidatePartyName;
		}


		public String getCandidatePartySymbol() {
			return candidatePartySymbol;
		}


		public void setCandidatePartySymbol(String candidatePartySymbol) {
			this.candidatePartySymbol = candidatePartySymbol;
		}


		public String getCandidateName() {
			return candidateName;
		}


		public void setCandidateName(String candidateName) {
			this.candidateName = candidateName;
		}


		public String getCandidateGender() {
			return candidateGender;
		}


		public void setCandidateGender(String candidateGender) {
			this.candidateGender = candidateGender;
		}


		public Integer getCandidateAge() {
			return candidateAge;
		}


		public void setCandidateAge(Integer candidateAge) {
			this.candidateAge = candidateAge;
		}


		public String getCandidateAddress() {
			return candidateAddress;
		}


		public void setCandidateAddress(String candidateAddress) {
			this.candidateAddress = candidateAddress;
		}


		public String getCandidateCity() {
			return candidateCity;
		}


		public void setCandidateCity(String candidateCity) {
			this.candidateCity = candidateCity;
		}


		public String getCandidateNationality() {
			return candidateNationality;
		}


		public void setCandidateNationality(String candidateNationality) {
			this.candidateNationality = candidateNationality;
		}


		public Long getCandidateMobileNo() {
			return candidateMobileNo;
		}


		public void setCandidateMobileNo(Long candidateMobileNo) {
			this.candidateMobileNo = candidateMobileNo;
		}


		public String getCandidateEmailId() {
			return candidateEmailId;
		}


		public void setCandidateEmailId(String candidateEmailId) {
			this.candidateEmailId = candidateEmailId;
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


		public String getCriminalCase() {
			return criminalCase;
		}


		public void setCriminalCase(String criminalCase) {
			this.criminalCase = criminalCase;
		}


		public Integer getYearsOfPunishment() {
			return yearsOfPunishment;
		}


		public void setYearsOfPunishment(Integer yearsOfPunishment) {
			this.yearsOfPunishment = yearsOfPunishment;
		}


		public Integer getReleasedYear() {
			return releasedYear;
		}


		public void setReleasedYear(Integer releasedYear) {
			this.releasedYear = releasedYear;
		}


		public byte[] getCandidateImage() {
			return candidateImage;
		}


		public void setCandidateImage(byte[] candidateImage) {
			this.candidateImage = candidateImage;
		}


		public byte[] getSymbolImage() {
			return symbolImage;
		}


		public void setSymbolImage(byte[] symbolImage) {
			this.symbolImage = symbolImage;
		}


		public String getImgPath() {
			return imgPath;
		}


		public void setImgPath(String imgPath) {
			this.imgPath = imgPath;
		}


		public String getImgPath1() {
			return imgPath1;
		}


		public void setImgPath1(String imgPath1) {
			this.imgPath1 = imgPath1;
		}


		//toString
		@Override
		public String toString() {
			return "Candidate [electionId=" + electionId + ", candidateId=" + candidateId + ", candidatePartyName="
					+ candidatePartyName + ", candidatePartySymbol=" + candidatePartySymbol + ", candidateName="
					+ candidateName + ", candidateGender=" + candidateGender + ", candidateAge=" + candidateAge
					+ ", candidateAddress=" + candidateAddress + ", candidateCity=" + candidateCity
					+ ", candidateNationality=" + candidateNationality + ", candidateMobileNo=" + candidateMobileNo
					+ ", candidateEmailId=" + candidateEmailId + ", history=" + history + ", data=" + data
					+ ", criminalCase=" + criminalCase + ", yearsOfPunishment=" + yearsOfPunishment + ", releasedYear="
					+ releasedYear + ", candidateImage=" + Arrays.toString(candidateImage) + ", symbolImage="
					+ Arrays.toString(symbolImage) + ", imgPath=" + imgPath + ", imgPath1=" + imgPath1 + "]";
		}


		
		
		
		
		
}

		
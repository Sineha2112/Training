package com.project.evotingsystemspring.model;


import java.util.Arrays;

import org.springframework.stereotype.Repository;

@Repository
public class Candidate {
	//data members of candidate class
		private Integer electionId;
		private Integer candidateId;
		private String canPartyName;
		private String canPartySymbol;
		private String candidateName;
		private String canGender;
		private Integer canAge;
		private String canAddress;
		private String canCity;
		private String canNationality;
		private Long canMobileNo;
		private String canEmailId;
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
		public Candidate(Integer electionId, Integer candidateId, String canPartyName, String canPartySymbol,
				String candidateName, String canGender, Integer canAge) {
			super();
			this.electionId = electionId;
			this.candidateId = candidateId;
			this.canPartyName = canPartyName;
			this.canPartySymbol = canPartySymbol;
			this.candidateName = candidateName;
			this.canGender = canGender;
			this.canAge = canAge;
		}


		public Candidate(String canAddress, String canCity, String canNationality, Long canMobileNo, String canEmailId,
				String history, String data) {
			super();
			this.canAddress = canAddress;
			this.canCity = canCity;
			this.canNationality = canNationality;
			this.canMobileNo = canMobileNo;
			this.canEmailId = canEmailId;
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


		public String getCanPartyName() {
			return canPartyName;
		}


		public void setCanPartyName(String canPartyName) {
			this.canPartyName = canPartyName;
		}


		public String getCanPartySymbol() {
			return canPartySymbol;
		}


		public void setCanPartySymbol(String canPartySymbol) {
			this.canPartySymbol = canPartySymbol;
		}


		public String getCandidateName() {
			return candidateName;
		}


		public void setCandidateName(String candidateName) {
			this.candidateName = candidateName;
		}


		public String getCanGender() {
			return canGender;
		}


		public void setCanGender(String canGender) {
			this.canGender = canGender;
		}


		public Integer getCanAge() {
			return canAge;
		}


		public void setCanAge(Integer canAge) {
			this.canAge = canAge;
		}


		public String getCanAddress() {
			return canAddress;
		}


		public void setCanAddress(String canAddress) {
			this.canAddress = canAddress;
		}


		public String getCanCity() {
			return canCity;
		}


		public void setCanCity(String canCity) {
			this.canCity = canCity;
		}


		public String getCanNationality() {
			return canNationality;
		}


		public void setCanNationality(String canNationality) {
			this.canNationality = canNationality;
		}


		public Long getCanMobileNo() {
			return canMobileNo;
		}


		public void setCanMobileNo(Long canMobileNo) {
			this.canMobileNo = canMobileNo;
		}


		public String getCanEmailId() {
			return canEmailId;
		}


		public void setCanEmailId(String canEmailId) {
			this.canEmailId = canEmailId;
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
			return "Candidate [electionId=" + electionId + ", candidateId=" + candidateId + ", canPartyName="
					+ canPartyName + ", canPartySymbol=" + canPartySymbol + ", candidateName=" + candidateName
					+ ", canGender=" + canGender + ", canAge=" + canAge + ", canAddress=" + canAddress + ", canCity="
					+ canCity + ", canNationality=" + canNationality + ", canMobileNo=" + canMobileNo + ", canEmailId="
					+ canEmailId + ", history=" + history + ", data=" + data + ", criminalCase=" + criminalCase
					+ ", yearsOfPunishment=" + yearsOfPunishment + ", releasedYear=" + releasedYear
					+ ", candidateImage=" + Arrays.toString(candidateImage) + ", symbolImage="
					+ Arrays.toString(symbolImage) + ", imgPath=" + imgPath + ", imgPath1=" + imgPath1 + "]";
		}
		
		
		
		
		
}

		
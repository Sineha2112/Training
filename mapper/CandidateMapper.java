package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Candidate;

public class CandidateMapper implements RowMapper<Candidate> {

	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidate candidate=new Candidate();
		
		byte[] canImg=rs.getBytes(1);
		byte[] syImg=rs.getBytes(2);
		int eId=rs.getInt(3);
		int cId=rs.getInt(4);
		String pName=rs.getString(5);
		String pSymbol=rs.getString(6);
		String cName=rs.getString(7);
		String gender=rs.getString(8);
		int age=rs.getInt(9);
		String address=rs.getString(10);
		String city=rs.getString(11);
		String nationality=rs.getString(12);
		Long mNo=rs.getLong(13);
		String email=rs.getString(14);
		String history=rs.getString(15);
		
		String base64Image = Base64.getEncoder().encodeToString(canImg);
		String base64Image1 = Base64.getEncoder().encodeToString(syImg);
		
		candidate.setCandidateImage(canImg);
		candidate.setSymbolImage(syImg);
		candidate.setImgPath(base64Image);
		candidate.setImgPath1(base64Image1);
		candidate.setElectionId(eId);
		candidate.setCandidateId(cId);
		candidate.setCandidatePartyName(pName);
		candidate.setCandidatePartySymbol(pSymbol);
		candidate.setCandidateName(cName);
		candidate.setCandidateGender(gender);
		candidate.setCandidateAge(age);
		candidate.setCandidateAddress(address);
		candidate.setCandidateCity(city);
		candidate.setCandidateNationality(nationality);
		candidate.setCandidateMobileNo(mNo);
		candidate.setCandidateEmailId(email);
		candidate.setHistory(history);
		
		return candidate;
	}

}

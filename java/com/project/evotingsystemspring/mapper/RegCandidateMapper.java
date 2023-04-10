package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Candidate;

public class RegCandidateMapper implements RowMapper<Candidate>{

	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidate candidate=new Candidate();
		String name=rs.getString(1);
		String pName=rs.getString(2);
		String pSymbol=rs.getString(3);
		String gender=rs.getString(4);
		Integer age=rs.getInt(5);
		String address=rs.getString(6);
		String city=rs.getString(7);
		String nationality=rs.getString(8);
		Long mNo=rs.getLong(9);
		String mailId=rs.getString(10);
		String criminalRec=rs.getString(11);
		
		
		candidate.setCandidateName(name);
		candidate.setCandidatePartyName(pName);
		candidate.setCandidatePartySymbol(pSymbol);
		candidate.setCandidateGender(gender);
		candidate.setCandidateAge(age);
		candidate.setCandidateAddress(address);
		candidate.setCandidateCity(city);
		candidate.setCandidateNationality(nationality);
		candidate.setCandidateMobileNo(mNo);
		candidate.setCandidateEmailId(mailId);
		candidate.setCriminalCase(criminalRec);
		
		
		
		return candidate;
	}

}

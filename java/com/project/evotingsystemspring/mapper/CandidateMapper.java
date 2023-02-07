package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Candidate;

public class CandidateMapper implements RowMapper<Candidate> {

	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidate c=new Candidate();
		int eId=rs.getInt(1);
		int cId=rs.getInt(2);
		String pName=rs.getString(3);
		String pSymbol=rs.getString(4);
		String cName=rs.getString(5);
		String gender=rs.getString(6);
		int age=rs.getInt(7);
		String address=rs.getString(8);
		String city=rs.getString(9);
		String nationality=rs.getString(10);
		Long mNo=rs.getLong(11);
		String email=rs.getString(12);
		String history=rs.getString(13);
		
		c.setElectionId(eId);
		c.setCandidateId(cId);
		c.setPartyName(pName);
		c.setPartySymbol(pSymbol);
		c.setCandidateName(cName);
		c.setGender(gender);
		c.setAge(age);
		c.setAddress(address);
		c.setCity(city);
		c.setNationality(nationality);
		c.setMobileNo(mNo);
		c.setEmailId(email);
		c.setHistory(history);
		
		return c;
	}

}

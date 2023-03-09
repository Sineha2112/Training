package com.project.evotingsystemspring.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Voter;

public class VoterMapper implements RowMapper<Voter> {

	@Override
	public Voter mapRow(ResultSet rs, int rowNum) throws SQLException {
		Voter voter=new Voter();
		
		Integer id=rs.getInt(1);
		String name=rs.getString(2); 
		
		Date dob=rs.getDate(3); 
		
		Integer age=rs.getInt(4); 
		String vId=rs.getString(5);
		String fname=rs.getString(6);
		String gender=rs.getString(7);
		String address=rs.getString(8);
		String city=rs.getString(9);
		String nationality=rs.getString(10);
		Long mNo=rs.getLong(11) ;
		String email=rs.getString(12) ;
	
		voter.setUserId(id);
		voter.setVoterName(name);
		voter.setDateOfBirth(dob);
		voter.setAge(age);
		voter.setVoterId(vId);
		voter.setFatherName(fname);
		voter.setGender(gender);
		voter.setAddress(address);
		voter.setCity(city);
		voter.setNationality(nationality);
		voter.setMobileNumber(mNo);
		voter.setEmailId(email);
		
		
		return voter;
	}

}

package com.project.evotingsystemspring.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.NRIVoter;

public class NriVoterMapper implements RowMapper<NRIVoter>{

	@Override
	public NRIVoter mapRow(ResultSet rs, int rowNum) throws SQLException {
		NRIVoter nVoter=new NRIVoter();
		
		Integer id=rs.getInt("nri_id");
		String name=rs.getString("voter_name");
		Date dob=rs.getDate("date_of_birth");
		Integer age=rs.getInt("age");
		String vId=rs.getString("voter_id");
		String fname=rs.getString("father_name");
		String gender=rs.getString("gender");
		String nationality=rs.getString("nationality");
		String state=rs.getString("state");
		String city=rs.getString("city");
		String email=rs.getString("email_id");
		
		
		nVoter.setNriId(id);
		nVoter.setNriVoterName(name);
		nVoter.setNriDateOfBirth(dob);
		nVoter.setNriAge(age);
		nVoter.setNriVoterId(vId);
		nVoter.setNriFatherName(fname);
		nVoter.setNriGender(gender);
		nVoter.setNriNationality(nationality);
		nVoter.setNriState(state);
		nVoter.setNriCity(city);
		nVoter.setNriEmailId(email);
		
		
		return nVoter;
	}

}

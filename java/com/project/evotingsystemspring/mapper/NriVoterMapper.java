package com.project.evotingsystemspring.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.NriVoter;

public class NriVoterMapper implements RowMapper<NriVoter>{

	@Override
	public NriVoter mapRow(ResultSet rs, int rowNum) throws SQLException {
		NriVoter n=new NriVoter();
		Integer id=rs.getInt(1);
		String name=rs.getString(2);
		Date dob=rs.getDate(3);
		Integer age=rs.getInt(4);
		String vId=rs.getString(5);
		String fname=rs.getString(6);
		String gender=rs.getString(7);
		String nationality=rs.getString(8);
		String state=rs.getString(9);
		String city=rs.getString(10);
		String email=rs.getString(11);
		String password=rs.getString(12);
		
		n.setNriId(id);
		n.setVoterName(name);
		n.setDateOfBirth(dob);
		n.setAge(age);
		n.setVoterId(vId);
		n.setFatherName(fname);
		n.setGender(gender);
		n.setNationality(nationality);
		n.setState(state);
		n.setCity(city);
		n.setEmailId(email);
		n.setUserPassword(password);
		
		return n;
	}

}

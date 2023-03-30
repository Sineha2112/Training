package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Voter;

public class MobileNoMapper implements RowMapper<Voter>{

	@Override
	public Voter mapRow(ResultSet rs, int rowNum) throws SQLException {
		Voter voter=new Voter();
	
		Long mobileNo=rs.getLong("mobileNumber");
		
		voter.setMobileNumber(mobileNo);
		return voter;
		
	} 

}

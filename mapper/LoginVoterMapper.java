package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Voter;

public class LoginVoterMapper implements RowMapper<Voter>{

	@Override
	public Voter mapRow(ResultSet rs, int rowNum) throws SQLException {
		Voter voter=new Voter();
		
		String vname=rs.getString("voter_name");
		String voterId=rs.getString("voter_id");
		String password=rs.getString("voter_password");
		
		voter.setVoterName(vname);
		voter.setVoterId(voterId);
		voter.setUserPassword(password);
		
		return voter;
	}

}

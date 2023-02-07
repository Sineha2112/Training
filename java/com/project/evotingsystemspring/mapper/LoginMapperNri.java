package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.NriVoter;


public class LoginMapperNri implements RowMapper<NriVoter>{

	@Override
	public NriVoter mapRow(ResultSet rs, int rowNum) throws SQLException {
		NriVoter nVoter=new NriVoter();
		
		String vname=rs.getString("voter_name");
		String vId=rs.getString("voter_id");
		String password=rs.getString("voter_password");
		
		nVoter.setVoterName(vname);
		nVoter.setVoterId(vId);
		nVoter.setUserPassword(password);
		
		return nVoter;
	}

}

package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.NRIVoter;


public class LoginMapperNri implements RowMapper<NRIVoter>{

	@Override
	public NRIVoter mapRow(ResultSet rs, int rowNum) throws SQLException {
		NRIVoter nVoter=new NRIVoter();
		
		String vname=rs.getString("voter_name");
		String vId=rs.getString("voter_id");
		String password=rs.getString("voter_password");
		
		nVoter.setNriVoterName(vname);
		nVoter.setNriVoterId(vId);
		nVoter.setnUserPassword(password);
		
		return nVoter;
	}

}

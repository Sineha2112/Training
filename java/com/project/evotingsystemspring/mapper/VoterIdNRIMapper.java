package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.NRIVoter;

public class VoterIdNRIMapper implements RowMapper<NRIVoter>{

	@Override
	public NRIVoter mapRow(ResultSet rs, int rowNum) throws SQLException {
		NRIVoter nVoter=new NRIVoter();
		
		String voterId=rs.getString("voter_id");
		
		nVoter.setNriVoterId(voterId);
		return nVoter;
	}

	

}

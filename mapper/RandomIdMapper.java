package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Voter;

public class RandomIdMapper implements RowMapper<Voter>{

	@Override
	public Voter mapRow(ResultSet rs, int rowNum) throws SQLException {
		Voter voter=new Voter();
		
		Integer uId=rs.getInt("user_id");
		String name=rs.getString("voter_name");
		String voterId=rs.getString("voter_id");
		
		voter.setUserId(uId);
		voter.setVoterName(name);
		voter.setVoterId(voterId);
		return voter;
	}

}

package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.CastingVote;

public class PerVoteMapper implements RowMapper<CastingVote>{

	@Override
	public CastingVote mapRow(ResultSet rs, int rowNum) throws SQLException {
		CastingVote castVote=new CastingVote();
		String voterId=rs.getString("voter_id");
		
		castVote.setVoterId(voterId);
		return castVote;
	}

}

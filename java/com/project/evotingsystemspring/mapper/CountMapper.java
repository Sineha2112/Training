package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.CastingVote;

public class CountMapper implements RowMapper<CastingVote> {

	@Override
	public CastingVote mapRow(ResultSet rs, int rowNum) throws SQLException {
		CastingVote castvote=new CastingVote();
		String vote=rs.getString("vote");
		
		castvote.setVote(vote);
		return castvote;
	}

}

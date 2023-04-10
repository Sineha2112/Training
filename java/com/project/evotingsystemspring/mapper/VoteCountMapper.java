package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.VoteCount;

public class VoteCountMapper implements RowMapper<VoteCount> {

	@Override
	public VoteCount mapRow(ResultSet rs, int rowNum) throws SQLException {
		VoteCount voteCount=new VoteCount();
		String name=rs.getString(1);
		int count=rs.getInt(2);
		
		voteCount.setPartyName(name);
		voteCount.setCount(count);
		
		return voteCount;
	}

}

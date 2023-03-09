package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.VoteCount;

public class VoteCountMapper implements RowMapper<VoteCount> {

	@Override
	public VoteCount mapRow(ResultSet rs, int rowNum) throws SQLException {
		VoteCount vc=new VoteCount();
		String name=rs.getString(1);
		int count=rs.getInt(2);
		
		vc.setPartyName(name);
		vc.setCount(count);
		
		return vc;
	}

}

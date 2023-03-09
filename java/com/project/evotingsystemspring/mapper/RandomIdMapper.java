package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Voter;

public class RandomIdMapper implements RowMapper<Voter>{

	@Override
	public Voter mapRow(ResultSet rs, int rowNum) throws SQLException {
		Voter v=new Voter();
		
		Integer uId=rs.getInt(1);
		String name=rs.getString(2);
		
		v.setUserId(uId);
		v.setVoterName(name);
		return v;
	}

}

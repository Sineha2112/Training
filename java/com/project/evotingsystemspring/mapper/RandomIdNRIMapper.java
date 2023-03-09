package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.NRIVoter;

public class RandomIdNRIMapper implements RowMapper<NRIVoter> {

	@Override
	public NRIVoter mapRow(ResultSet rs, int rowNum) throws SQLException {
		NRIVoter nv=new NRIVoter();
		
		Integer uId=rs.getInt(1);
		String name=rs.getString(2);
		
		nv.setNriId(uId);
		nv.setNriVoterName(name);
		return nv;
	}

}

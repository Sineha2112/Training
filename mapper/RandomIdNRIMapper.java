package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.NRIVoter;

public class RandomIdNRIMapper implements RowMapper<NRIVoter> {

	@Override
	public NRIVoter mapRow(ResultSet rs, int rowNum) throws SQLException {
		NRIVoter nVoter=new NRIVoter();
		
		Integer uId=rs.getInt("nri_id");
		String name=rs.getString("voter_name");
		String voterId=rs.getString("voter_id");
		
		nVoter.setNriId(uId);
		nVoter.setNriVoterName(name);
		nVoter.setNriVoterId(voterId);
		return nVoter;
	}

}

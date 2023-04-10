package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Candidate;

public class PartyNameMapper implements RowMapper<Candidate> {

	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidate candidate=new Candidate();
		
		String pName=rs.getString("party_name");
		
		candidate.setCandidatePartyName(pName);
		
		return candidate;
	}

}

package com.project.evotingsystemspring.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.NRIVoter;

public class SearchListNRIMapper implements RowMapper<NRIVoter> {

	@Autowired
	NRIVoter nVoter;
	
	@Override
	public NRIVoter mapRow(ResultSet rs, int rowNum) throws SQLException {

		
		String nVoterName=rs.getString("voter_name");
		Date nVoterDob=rs.getDate("date_of_birth");
		Integer nVoterAge=rs.getInt("age");
		String nVoterVid=rs.getString("voter_id");
		String nVoterFname=rs.getString("father_name");
		String nVoterGender=rs.getString("gender");
		String nVoterNationality=rs.getString("nationality");
		String nVoterState=rs.getString("state");
		String nVoterCity=rs.getString("city");
		String nVoterEmail=rs.getString("email_id");
		String nVoterPname=rs.getString(13);
		String nVoterVoted=rs.getString(14);
		
		
		
		nVoter.setNriVoterName(nVoterName);
		nVoter.setNriDateOfBirth(nVoterDob);
		nVoter.setNriAge(nVoterAge);
		nVoter.setNriVoterId(nVoterVid);
		nVoter.setNriFatherName(nVoterFname);
		nVoter.setNriGender(nVoterGender);
		nVoter.setNriNationality(nVoterNationality);
		nVoter.setNriState(nVoterState);
		nVoter.setNriCity(nVoterCity);
		nVoter.setNriEmailId(nVoterEmail);
		nVoter.setPartyName(nVoterPname);
		nVoter.setVote(nVoterVoted);
		
		return nVoter;
		
	}

}

package com.project.evotingsystemspring.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Voter;

public class SearchListMapper implements RowMapper<Voter> {

	@Override
	public Voter mapRow(ResultSet rs, int rowNum) throws SQLException {

		Voter voter = new Voter();

		String voterName = rs.getString("voter_name");
		Date voterDob = rs.getDate("date_of_birth");
		Integer voterAge = rs.getInt("age");
		String voterVid = rs.getString("voter_id");
		String voterFname = rs.getString("father_name");
		String voterGender = rs.getString("gender");
		String voterAddress = rs.getString("address");
		String voterCity = rs.getString("city");
		String voterNationality = rs.getString("nationality");
		Long voterMno = rs.getLong("mobilenumber");
		String voterEmail = rs.getString("email_id");
		String voterPname = rs.getString("party_name");
		String voterVoted = rs.getString("vote");

		voter.setVoterName(voterName);
		voter.setDateOfBirth(voterDob);
		voter.setAge(voterAge);
		voter.setVoterId(voterVid);
		voter.setFatherName(voterFname);
		voter.setGender(voterGender);
		voter.setAddress(voterAddress);
		voter.setCity(voterCity);
		voter.setNationality(voterNationality);
		voter.setMobileNumber(voterMno);
		voter.setEmailId(voterEmail);
		voter.setPartyName(voterPname);
		voter.setVote(voterVoted);

		return voter;
	}

}

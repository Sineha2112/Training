package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Candidate;

public class CandidateGridMapper implements RowMapper<Candidate>{

	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidate candidate=new Candidate();
		
		int electionId=rs.getInt("election_id");
		int candidateId=rs.getInt("candidate_id");
		String partyName=rs.getString("party_name");
		String candidateName=rs.getString("candidate_name");
		String candidateGender=rs.getString("gender");
		int candidateAge=rs.getInt("age");
		String candidateAddress=rs.getString("address");
		String candidateCity=rs.getString("city");
		String candidateNationality=rs.getString("nationality");
		Long mobileNo=rs.getLong("mobileno");
		String emailId=rs.getString("emailid");
		
		
		candidate.setElectionId(electionId);
		candidate.setCandidateId(candidateId);
		candidate.setCandidatePartyName(partyName);
		candidate.setCandidateName(candidateName);
		candidate.setCandidateGender(candidateGender);
		candidate.setCandidateAge(candidateAge);
		candidate.setCandidateAddress(candidateAddress);
		candidate.setCandidateCity(candidateCity);
		candidate.setCandidateNationality(candidateNationality);
		candidate.setCandidateMobileNo(mobileNo);
		candidate.setCandidateEmailId(emailId);
		
		return candidate;
	}

}

package com.project.evotingsystemspring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.evotingsystemspring.model.Candidate;

@Repository
public class CandidateDAO {
	@Autowired
	JdbcTemplate jdbctemplate;
	
	Logger logger = LoggerFactory.getLogger(CandidateDAO.class);
	
	public void regCandidate(Candidate candidate) {
	logger.info("To Register Candidate");
	String query="insert into regCandidates(candidate_name,party_name,party_symbol,gender,age,address,city,nationality,mobileNo,emailId) values(?,?,?,?,?,?,?,?,?,?)";
	Object reg[]= {candidate.getCandidateName(),candidate.getPartyName(),candidate.getPartySymbol(),candidate.getGender(),candidate.getAge(),candidate.getAddress(),candidate.getCity(),candidate.getNationality(),candidate.getMobileNo(),candidate.getEmailId()};
	int rows=jdbctemplate.update(query, reg);
	System.out.println("Row Inserted:"+rows);
	}
}

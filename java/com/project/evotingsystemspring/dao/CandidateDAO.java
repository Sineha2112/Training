package com.project.evotingsystemspring.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.evotingsystemspring.daointerface.CandidateInterface;
import com.project.evotingsystemspring.mapper.CandidateMapper;
import com.project.evotingsystemspring.mapper.RegCandidateMapper;
import com.project.evotingsystemspring.model.Candidate;

@Repository
public class CandidateDAO implements CandidateInterface{
	@Autowired
	JdbcTemplate jdbctemplate;
	
	Logger logger = LoggerFactory.getLogger(CandidateDAO.class);
	
	public void regCandidate(Candidate candidate) {
	logger.info("To Register Candidate");
	String query="insert into regCandidates(candidate_name,party_name,party_symbol,gender,age,address,city,nationality,mobileNo,emailId,criminalRecords,yearsOfPunishment,releasedYear) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	Object[] reg= {candidate.getCandidateName(),candidate.getCanPartyName(),candidate.getCanPartySymbol(),candidate.getCanGender(),candidate.getCanAge(),candidate.getCanAddress(),candidate.getCanCity(),candidate.getCanNationality(),candidate.getCanMobileNo(),candidate.getCanEmailId(),candidate.getCriminalCase(),candidate.getYearsOfPunishment(),candidate.getReleasedYear()};
	jdbctemplate.update(query, reg);
	logger.info("Row Inserted");
	}
	
	public List<Candidate> viewRegCandidates() {
		String sql = "select candidate_name,party_name,party_symbol,gender,age,address,city,nationality,mobileNo,emailId,criminalRecords,yearsOfPunishment,releasedYear,candidateImage,symbolImage from regCandidates";
		List<Candidate> candidateList = jdbctemplate.query(sql, new RegCandidateMapper());
		logger.info(candidateList + "Fetched records");
		return candidateList;
	}
}

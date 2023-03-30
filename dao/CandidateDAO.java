package com.project.evotingsystemspring.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import com.project.evotingsystemspring.connection.ConnectionUtil;
import com.project.evotingsystemspring.daointerface.CandidateInterface;
import com.project.evotingsystemspring.mapper.RegCandidateMapper;
import com.project.evotingsystemspring.model.Candidate;


public class CandidateDAO implements CandidateInterface{
	
	JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	Logger logger = LoggerFactory.getLogger(CandidateDAO.class);
	
	public void regCandidate(Candidate candidate) {
	logger.info("To Register Candidate");
	String query="insert into regCandidates(candidate_name,party_name,party_symbol,gender,age,address,city,nationality,mobileNo,emailId,criminalRecords,yearsOfPunishment,releasedYear) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	Object[] reg= {candidate.getCandidateName(),candidate.getCandidatePartyName(),candidate.getCandidatePartySymbol(),candidate.getCandidateGender(),candidate.getCandidateAge(),candidate.getCandidateAddress(),candidate.getCandidateCity(),candidate.getCandidateNationality(),candidate.getCandidateMobileNo(),candidate.getCandidateEmailId(),candidate.getCriminalCase(),candidate.getYearsOfPunishment(),candidate.getReleasedYear()};
	jdbcTemplate.update(query, reg);
	logger.info("Row Inserted");
	}
	
	public List<Candidate> viewRegCandidates() {
		String sql = "select candidate_name,party_name,party_symbol,gender,age,address,city,nationality,mobileNo,emailId,criminalRecords,yearsOfPunishment,releasedYear,candidateImage,symbolImage from regCandidates";
		List<Candidate> candidateList = jdbcTemplate.query(sql, new RegCandidateMapper());
		logger.info(candidateList + "Fetched records");
		return candidateList;
	}
}

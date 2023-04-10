package com.project.evotingsystemspring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.evotingsystemspring.connection.ConnectionUtil;
import com.project.evotingsystemspring.daointerface.CandidateInterface;
import com.project.evotingsystemspring.mapper.MailIdMapper;
import com.project.evotingsystemspring.mapper.MobileNoMapper;
import com.project.evotingsystemspring.mapper.RegCandidateMapper;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.model.Voter;


public class CandidateDAO implements CandidateInterface{
	
	JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	Logger logger = LoggerFactory.getLogger(CandidateDAO.class);
	
	public void regCandidate(Candidate candidate) {
	logger.info("To Register Candidate");
	String query="insert into regCandidates(candidate_name,party_name,party_symbol,gender,age,address,city,nationality,mobileNo,emailId,criminalRecords,yearsOfPunishment,releasedYear) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	Object[] reg= {candidate.getCandidateName(),candidate.getCandidatePartyName(),candidate.getCandidatePartySymbol(),candidate.getCandidateGender(),candidate.getCandidateAge(),candidate.getCandidateAddress(),candidate.getCandidateCity(),candidate.getCandidateNationality(),candidate.getCandidateMobileNo(),candidate.getCandidateEmailId(),candidate.getCriminalCase(),candidate.getYearsOfPunishment(),candidate.getReleasedYear()};
	jdbcTemplate.update(query, reg);
	logger.info("Candidate Registered");
	}
	
	
	public List<Candidate> viewRegCandidates(Model model) throws JsonProcessingException {
		String sql = "select candidate_name,party_name,party_symbol,gender,age,address,city,nationality,mobileNo,emailId,criminalRecords from regCandidates";
		List<Candidate> candidateList = jdbcTemplate.query(sql, new RegCandidateMapper());
		List<Map<String,Object>> candidateListGrid=new ArrayList<>();
		for (Candidate gridList : candidateList) {
			Map<String,Object> list=new HashMap<>();
			list.put("CandidateName", gridList.getCandidateName());
			list.put("PartyName", gridList.getCandidatePartyName());
			list.put("PartySymbol", gridList.getCandidatePartySymbol());
			list.put("Gender", gridList.getCandidateGender());
			list.put("Age", gridList.getCandidateAge());
			list.put("Address", gridList.getCandidateAddress());
			list.put("City", gridList.getCandidateCity());
			list.put("Nationality", gridList.getCandidateNationality());
			list.put("MobileNumber", gridList.getCandidateMobileNo());
			list.put("Email", gridList.getCandidateEmailId());
			list.put("CriminalRecords", gridList.getCriminalCase());
			
			candidateListGrid.add(list);
			
		}
		ObjectMapper feedback=new ObjectMapper();
		String candidateLi=feedback.writeValueAsString(candidateListGrid);
		model.addAttribute("candidateList", candidateLi);
		return candidateList;
	}
}

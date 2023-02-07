package com.project.evotingsystemspring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.evotingsystemspring.dao.CandidateDAO;
import com.project.evotingsystemspring.model.Candidate;

@Controller
public class CandidateController {
	@Autowired
	CandidateDAO candidatedao;

	 Logger logger = LoggerFactory.getLogger(VoterController.class);
	 
	@PostMapping("/regCandidates")
	public String regCandidates(@RequestParam("name") String cName,@RequestParam("partyName") String pName,@RequestParam("partySymbol") String pSymbol,@RequestParam("gender") String gender,@RequestParam("age") Integer age,@RequestParam("address") String address,@RequestParam("city") String city,@RequestParam("nationality") String nationality,@RequestParam("mobileNumber") Long mNo,@RequestParam("email") String email) {
		logger.info("Through COntroller");
		Candidate candidate=new Candidate();
		
		candidate.setCandidateName(cName);
		candidate.setPartyName(pName);
		candidate.setPartySymbol(pSymbol);
		candidate.setAge(age);
		candidate.setGender(gender);
		candidate.setAddress(address);
		candidate.setCity(city);
		candidate.setNationality(nationality);
		candidate.setMobileNo(mNo);
		candidate.setEmailId(email);
		
		candidatedao.regCandidate(candidate);
		
		return "JSP/registercandidates.jsp";
		
	}

}

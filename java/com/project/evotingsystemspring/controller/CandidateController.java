package com.project.evotingsystemspring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.evotingsystemspring.dao.AdminDAO;
import com.project.evotingsystemspring.dao.CandidateDAO;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.service.CandidateService;

@Controller
public class CandidateController {
	@Autowired
	CandidateDAO candidateDao;
	@Autowired
	CandidateService cService;
	@Autowired
	AdminDAO adminDao;

	 Logger logger = LoggerFactory.getLogger(CandidateController.class);
	 
	@PostMapping("/regCandidates")
	public String regCandidates(@RequestParam("name") String cName,@RequestParam("partyName") String pName,@RequestParam("partySymbol") String pSymbol,@RequestParam("gender") String gender,@RequestParam("age") Integer age,@RequestParam("address") String address,
			@RequestParam("city") String city,@RequestParam("nationality") String nationality,@RequestParam("mobileNumber") Long mNo,@RequestParam("email") String email,@RequestParam("criminalRec") String criminalRec,@RequestParam("noOfYear") Integer noOfYear,@RequestParam("rYear") Integer rYear)
			{
		logger.info("Through COntroller");
		Candidate candidate=new Candidate();
		
		candidate.setCandidateName(cName);
		candidate.setCanPartyName(pName);
		candidate.setCanPartySymbol(pSymbol);
		candidate.setCanAge(age);
		candidate.setCanGender(gender);
		candidate.setCanAddress(address);
		candidate.setCanCity(city);
		candidate.setCanNationality(nationality);
		candidate.setCanMobileNo(mNo);
		candidate.setCanEmailId(email);
		candidate.setCriminalCase(criminalRec);
		candidate.setYearsOfPunishment(noOfYear);
		candidate.setReleasedYear(rYear);
		
	   cService.registerCandidateService(candidate);
		
		return "popUpCanRegister";
	}

	@RequestMapping("/viewRegCandidates")
	public String viewCandidate(Model model) {
		logger.info("Through Controller3");
		cService.viewCandService(model);
		return "viewRegCandidates";
	}
	
	@RequestMapping("/adminReportHomePage")
	public String reportPage() {
		logger.info("admin Report Page");
		return "adminpage";
	}
	
	@RequestMapping("/userVoteHomePage")
	public String votePage() {
		logger.info("Voter voted Page");
		return "voterhomepage";
	}
	
	@RequestMapping("/CandidateHomePage")
	public String canRegPage() {
		logger.info("Candidate Registration Page");
		return "home";
	}
}

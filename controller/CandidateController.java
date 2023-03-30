package com.project.evotingsystemspring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.evotingsystemspring.dao.AdminDAO;
import com.project.evotingsystemspring.dao.CandidateDAO;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.service.CandidateService;

@Controller
public class CandidateController {
	
	CandidateDAO candidateDao=new CandidateDAO();
	
	CandidateService candidateService=new CandidateService();

	AdminDAO adminDao=new AdminDAO();
	
	Candidate candidate=new Candidate();

	Logger logger = LoggerFactory.getLogger(CandidateController.class);
	 
	@RequestMapping("/registerCandidate")
	public String registerCandidatePage(@ModelAttribute("registerCandidates") Candidate candidate) {
		return "registerCandidates.html";
		
	}
	
	@GetMapping("/regCandidates")
	public String regCandidates(@ModelAttribute("registerCandidates") Candidate candidate){
		logger.info("Through COntroller");
		
	   candidateService.registerCandidateService(candidate);
		
		return "popUpCandidateRegister.html";
	}

	@RequestMapping("/viewRegCandidates")
	public String viewCandidate(Model model) {
		logger.info("Through Controller3");
		candidateService.viewCandService(model);
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
	public String candidateRegPage() {
		logger.info("Candidate Registration Page");
		return "home.html";
	}
}

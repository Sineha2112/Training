package com.project.evotingsystemspring.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.evotingsystemspring.dao.AdminDAO;
import com.project.evotingsystemspring.dao.CandidateDAO;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.service.CandidateService;
import com.project.evotingsystemspring.validation.ValidationVs;

@Controller
public class CandidateController {
	
	CandidateDAO candidateDao=new CandidateDAO();
	
	CandidateService candidateService=new CandidateService();

	AdminDAO adminDao=new AdminDAO();
	
	Candidate candidate=new Candidate();

	Logger logger = LoggerFactory.getLogger(CandidateController.class);
	 
	@RequestMapping("/registerCandidate")
	public String registerCandidatePage(@ModelAttribute("registerCandidates") Candidate candidate,HttpSession session,Model model) {
		return "registerCandidates.html";
		
	}
	
	@GetMapping("/regCandidates")
	public String regCandidates(@ModelAttribute("registerCandidates") Candidate candidate,HttpSession session,Model model){
		logger.info("Through COntroller");
ValidationVs validation=new ValidationVs();
		
	
		for (int i = 1; i <=20; i++) {
			session.removeAttribute("errorMessage1" + i);
		}

		if (Boolean.FALSE.equals(validation.cNameValidation(candidate.getCandidateName(), model))
				|| Boolean.FALSE.equals(validation.nameValidation(candidate.getCandidatePartyName(), model))
				|| Boolean.FALSE.equals(validation.nameValidation(candidate.getCandidatePartySymbol(), model))
				|| Boolean.FALSE.equals(validation.genderValidation(candidate.getCandidateGender(), model))
				|| Boolean.FALSE.equals(validation.candidateAgeValidation(candidate.getCandidateAge(), model))
				|| Boolean.FALSE.equals(validation.addressValidation(candidate.getCandidateAddress(), model))
				|| Boolean.FALSE.equals(validation.cityValidation(candidate.getCandidateCity(), model))
				|| Boolean.FALSE.equals(validation.nationalityValidation(candidate.getCandidateNationality(), model))
				|| Boolean.FALSE.equals(validation.phoneNoValidation(candidate.getCandidateMobileNo(), model))
				|| Boolean.FALSE.equals(validation.emailValidation(candidate.getCandidateEmailId(), model))) {
			
			for (int j = 1; j <=19; j++) {
				if (model.getAttribute("errorMessage" + j) != null) {
					String errorMessage = (String) model.getAttribute("errorMessage" + j);
					model.addAttribute("ErrorMessage", errorMessage);
				}
			}
			return "errorPopUp.html";
		}
		
	   candidateService.registerCandidateService(candidate);
		
		return "popUpCandidateRegister.html";
	}

	@RequestMapping("/viewRegCandidates")
	public String viewCandidate(Model model)throws JsonProcessingException {
		logger.info("Through Controller3");
		candidateService.viewCandService(model);
		return "appliedCandidatesList.html";
	}
	
	@RequestMapping("/adminReportHomePage")
	public String reportPage() {
		logger.info("admin Report Page");
		return "voterHomepage.html";
	}
	
	@RequestMapping("/userVoteHomePage")
	public String votePage() {
		logger.info("Voter voted Page");
		return "voterHomepage.html";
	}
	
	@RequestMapping("/CandidateHomePage")
	public String candidateRegPage() {
		logger.info("Candidate Registration Page");
		return "home.html";
	}
}

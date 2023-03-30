package com.project.evotingsystemspring.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.evotingsystemspring.dao.VoterDAO;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.myexception.DuplicationOfMailException;
import com.project.evotingsystemspring.myexception.InvalidAgeException;
import com.project.evotingsystemspring.myexception.InvalidEmailIdException;
import com.project.evotingsystemspring.service.VoterService;
@Controller
public class UserController {
	
VoterDAO voterDao=new VoterDAO();
	
	Voter voter=new Voter();

	VoterService voterService=new VoterService();
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	 
	 @RequestMapping("/home")
		public String home() {
			logger.info("Through Controller");
			return "home.html";
		}
	 
	@RequestMapping("/registerDemo")
	public String register(Model model,HttpSession session) throws InvalidAgeException, InvalidEmailIdException, DuplicationOfMailException{
	
		
		model.addAttribute("User", voter);
		voterService.voterRegisterService(voter, session);
		
		return "register.html";
		
	}
	
	@RequestMapping("/loginUser")
	public String loginVoter(Model model,HttpSession session) {
		logger.info("Through login controller");
		model.addAttribute("Voter", voter);
		
		
		if(Boolean.TRUE.equals(voterService.voterLoginService(voter, session, model))) {
			return "null";
		}
		else if(Boolean.FALSE.equals(voterService.voterLoginService(voter, session, model))) {
			return "residentvoter";
		}
		return "residentvoter";
		
		
	}


}

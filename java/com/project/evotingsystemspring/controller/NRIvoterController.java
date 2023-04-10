package com.project.evotingsystemspring.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.evotingsystemspring.dao.NRIvoterDAO;
import com.project.evotingsystemspring.dao.VoterDAO;
import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.myexception.AlreadyVotedException;
import com.project.evotingsystemspring.service.NRIVoterService;
import com.project.evotingsystemspring.service.VoterService;
import com.project.evotingsystemspring.validation.ValidationVs;

@Controller
public class NRIvoterController {
	
	NRIvoterDAO nVoterDao=new NRIvoterDAO();
	
	VoterDAO voterDao=new VoterDAO();
	
	VoterService voterService=new VoterService();

	NRIVoter nVoter=new NRIVoter();
	
	NRIVoterService nVoterService=new NRIVoterService();
	
	Logger logger = LoggerFactory.getLogger(NRIvoterController.class);
	 
	
	@RequestMapping("/reg")
	public String registerUser(@ModelAttribute("User") Voter voter,HttpSession session,Model model) {
		return "registerVoter.html";
	}
	
	@RequestMapping("/registerVoter")
	public String register(@ModelAttribute("User") Voter voter,HttpSession session,Model model)  {
		logger.info("Through Controller3");
		
		ValidationVs validation=new ValidationVs();
		
		Date dob = voter.getDateOfBirth();
		Integer age = validation.ageCalculator(dob);
		voter.setAge(age);
		
		for (int i = 1; i <=20; i++) {
			session.removeAttribute("errorMessage1" + i);
		}

		if (Boolean.FALSE.equals(validation.nameValidation(voter.getVoterName(), model))
				|| Boolean.FALSE.equals(validation.dateOfBirthValidation(voter.getDateOfBirth(), model))
				|| Boolean.FALSE.equals(validation.ageValidation(age, model))
				|| Boolean.FALSE.equals(validation.voterIdValidation(voter.getVoterId(), model))
				|| Boolean.FALSE.equals(validation.fatherNameValidation(voter.getFatherName(), model))
				|| Boolean.FALSE.equals(validation.genderValidation(voter.getGender(), model))
				|| Boolean.FALSE.equals(validation.addressValidation(voter.getAddress(), model))
				|| Boolean.FALSE.equals(validation.cityValidation(voter.getCity(), model))
				|| Boolean.FALSE.equals(validation.nationalityValidation(voter.getNationality(), model))
				|| Boolean.FALSE.equals(validation.phoneNoValidation(voter.getMobileNumber(), model))
				|| Boolean.FALSE.equals(validation.emailValidation(voter.getEmailId(), model))
				|| Boolean.FALSE.equals(validation.passwordValidation(voter.getUserPassword(), model))
				|| Boolean.FALSE.equals(voterDao.emailExist(voter, model))
				|| Boolean.FALSE.equals(voterDao.mobileNoExist(voter, model))
				|| Boolean.FALSE.equals(voterDao.voterIdExist(voter, model))) {
			
			for (int j = 1; j <=20; j++) {
				if (model.getAttribute("errorMessage" + j) != null) {
					String errorMessage = (String) model.getAttribute("errorMessage" + j);
					model.addAttribute("ErrorMessage", errorMessage);
				}
			}
			return "errorPopUp.html";
		}
		voterService.voterRegisterService(voter, session);
		
		return "popUpRegister.html";
	}
	
	
	@GetMapping("/loginNriVoter")
	public String loginVoter(@ModelAttribute("NRILoginVoter") NRIVoter nVoter,HttpSession session,Model model) {
		logger.info("Through login controller");
		
		if(Boolean.TRUE.equals(nVoterService.voterNRIlogin(nVoter, session,model))) {
			return "voterNRIhomepage.html";
		}
		else if(Boolean.FALSE.equals(nVoterService.voterNRIlogin(nVoter, session,model))) {
			return "residentNRIvoter.html";
		}
		return "residentNRIvoter.html";
		
	}
	
	//Logout Controller 
    @RequestMapping("/Logout")
    public String logOut(HttpSession session) {
          logger.info("Logout");
        session.removeAttribute("userName");
        session.removeAttribute("VoterId");
        session.invalidate();
      return "home";  
    }
	
    //forgot password  controller
    @RequestMapping("/forgotPasswordNRI")
    public String forgotPasswordPage(@ModelAttribute("forgotPassword") NRIVoter nVoter) {
    	return "forgotPasswordNRI.html";
    }
	
	@RequestMapping("/viewNRIuser")
	public String viewNriProfile(HttpSession session) {
		logger.info("Through Controller4");
		nVoterService.viewService(session);
		return "voterNRIprofile.html";
		
	}
	
	@RequestMapping("/updateNRIpage")
	public String updateNRIpage(@ModelAttribute("updateNRIdetails") NRIVoter nVoter,HttpSession session) {
		return "updateNRIvoter.html";
	}
	
	@GetMapping("/updateNRIprofile")
	public String updateProfile(@ModelAttribute("updateNRIdetails") NRIVoter nVoter,HttpSession session) {
		logger.info("Update profile ");
		
		nVoterService.updateService(nVoter, session);
		
		return "voterNRIprofile.html" ;
	}
	
	//feedback
	@RequestMapping("/feedbackNRIpage")
	public String feedbackNRI(@ModelAttribute("feedback") Voter voters) {
		return "feedbackNRIvoter.html";
	}
	
	@GetMapping("/feedbackNRI")
	public String userFeedback(@ModelAttribute("feedback") Voter voters) {
		logger.info("Through Controller9");
		
		voterService.feedbackService(voters);
		
		return "popUpFeedbackNRI.html" ;
	}
	
	//reports
	@RequestMapping("/reportNRIPage")
	public String reportPage(@ModelAttribute("reportNRI") Voter vote) {
		return "reportNRI.html";
	}
	
	@GetMapping("/reportNRI")
	public String userComplaints(@ModelAttribute("reportNRI") Voter vote) {
		logger.info("Through Controller9");
		
		voterService.complaintService(vote);
		
		return "voterNRIhomepage.html";
		
	}
	
	//Candidate
		@RequestMapping("/adminHomePage")
		public String candidatePage() {
			logger.info("admin Add Page");
			return "adminPage.html";
		}
		
		//voter forgot password
		@GetMapping("/updatePassword")
		public String updatePassword(@ModelAttribute("forgotPassword") Voter voter) {
			logger.info("Update profile ");
			
			voterService.updatePasswordService(voter);
			return "residentVoter.html";	
			
		}
		
	
}

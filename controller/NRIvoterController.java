package com.project.evotingsystemspring.controller;

import java.sql.Date;
import javax.servlet.http.HttpSession;

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

import com.project.evotingsystemspring.dao.NRIvoterDAO;
import com.project.evotingsystemspring.dao.VoterDAO;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.myexception.InvalidAgeException;
import com.project.evotingsystemspring.myexception.InvalidCityException;
import com.project.evotingsystemspring.myexception.InvalidDobException;
import com.project.evotingsystemspring.myexception.InvalidEmailIdException;
import com.project.evotingsystemspring.myexception.InvalidGenderException;
import com.project.evotingsystemspring.myexception.InvalidNameException;
import com.project.evotingsystemspring.myexception.InvalidNationalityException;
import com.project.evotingsystemspring.myexception.InvalidPasswordException;
import com.project.evotingsystemspring.myexception.InvalidVoterIdException;
import com.project.evotingsystemspring.service.NRIVoterService;
import com.project.evotingsystemspring.service.VoterService;
import com.project.evotingsystemspring.validation.ValidationVs;

@Controller
public class NRIvoterController {
	
	NRIvoterDAO nVoterDao=new NRIvoterDAO();
	
	VoterService voterService=new VoterService();

	NRIVoter nVoter=new NRIVoter();
	
	NRIVoterService nVoterService=new NRIVoterService();
	
	Logger logger = LoggerFactory.getLogger(NRIvoterController.class);
	 
	
	 @RequestMapping("/regNRI")
	 public String registerUser(@ModelAttribute("NRIVoter") NRIVoter nVoter,HttpSession session) {
			return "registerNRIvoter.html";
		}
	 
	 @RequestMapping("/voterNRIHomePage")
		public String voterNRIPage() {
			logger.info("Voter NRI Page");
			return "voterNRIhomepage.html";
		}
	 
	 @RequestMapping("/registerNRIVoter")
	public String register(@ModelAttribute("NRIVoter") NRIVoter nVoter,HttpSession session ) throws InvalidAgeException{
		logger.info("Through Controller2");
		
		nVoterService.voterNRIregister(nVoter,session);
		
		return "popUpNRIregister.html";
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
	
    @RequestMapping("/forgotPasswordNRI")
    public String forgotPasswordPage(@ModelAttribute("forgotPassword") NRIVoter nVoter) {
    	return "forgotPasswordNRI.html";
    }
    
	@GetMapping("/updateNRIPassword")
	public String updatePassword(@ModelAttribute("forgotPassword") NRIVoter nVoter) {
		logger.info("Update profile ");
		
		nVoterService.updatePasswordService(nVoter);
		return "residentNRIvoter.html";	
		
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
	public String feedbackNRI(@ModelAttribute("feedback") Voter voter) {
		return "feedbackNRIvoter.html";
	}
	
	@GetMapping("/feedbackNRI")
	public String userFeedback(@ModelAttribute("feedback") Voter voter) {
		logger.info("Through Controller9");
		
		voterService.feedbackService(voter);
		
		return "popUpFeedbackNRI.html" ;
	}
	
	@RequestMapping("/voterNRIhomepageFeedback")
	public String voterNRIFeedPage() {
		logger.info("Voter NRI Feedback Page");
		return "voterNRIhomepage.html";
	}
	
	//reports
	@RequestMapping("/reportNRIPage")
	public String reportPage(@ModelAttribute("reportNRI") Voter voter) {
		return "reportNRI.html";
	}
	
	@GetMapping("/reportNRI")
	public String userComplaints(@ModelAttribute("reportNRI") Voter voter) {
		logger.info("Through Controller9");
		
		voterService.complaintService(voter);
		
		return "voterNRIhomepage.html";
		
	}
	
	//Candidate
		@RequestMapping("/adminHomePage")
		public String candidatePage() {
			logger.info("admin Add Page");
			return "adminPage.html";
		}
		
		@RequestMapping("/resetPasswordPage")
		public String resetPasswordPage() {
			logger.info("Password Reset");
			return "residentvoter";
		}
		
		
	
}

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
import com.project.evotingsystemspring.model.Admin;
import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.myexception.AlreadyVotedException;
import com.project.evotingsystemspring.service.NRIVoterService;
import com.project.evotingsystemspring.service.VoterService;
import com.project.evotingsystemspring.validation.ValidationVs;

@Controller
public class VoterController {
	
	
	VoterDAO voterDao=new VoterDAO();
	
	NRIvoterDAO nVoterDao=new NRIvoterDAO();
	
	Voter voter=new Voter();

	VoterService voterService=new VoterService();
	
	NRIVoterService nVoterService=new NRIVoterService();
	
	Logger logger = LoggerFactory.getLogger(VoterController.class);
	 
	//handler
	@RequestMapping("/")
	public String home() {
		logger.info("Through Controller");
		return "home.html";
	}
	
	//NRI voter registration
	@RequestMapping("/regNRI")
	 public String registerUser(@ModelAttribute("NRIVoter") NRIVoter nVoter,HttpSession session,Model model) {
			return "registerNRIvoter.html";
		}
	 
	 @RequestMapping("/registerNRIVoter")
	public String register(@ModelAttribute("NRIVoter") NRIVoter nVoter,HttpSession session,Model model ) {
		logger.info("Through Controller2");
		
		ValidationVs validation=new ValidationVs();
		
		Date dob=nVoter.getNriDateOfBirth();
		Integer age=validation.ageCalculator(dob);
		nVoter.setNriAge(age);
		
		for (int i = 1; i <=20; i++) {
			session.removeAttribute("errorMessage1" + i);
		}

		if (Boolean.FALSE.equals(validation.nameValidation(nVoter.getNriVoterName(), model))
				|| Boolean.FALSE.equals(validation.dateOfBirthValidation(nVoter.getNriDateOfBirth(), model))
				|| Boolean.FALSE.equals(validation.ageValidation(age, model))
				|| Boolean.FALSE.equals(validation.voterIdValidation(nVoter.getNriVoterId(), model))
				|| Boolean.FALSE.equals(validation.fatherNameValidation(nVoter.getNriFatherName(), model))
				|| Boolean.FALSE.equals(validation.genderValidation(nVoter.getNriGender(), model))
				|| Boolean.FALSE.equals(validation.addressValidation(nVoter.getNriAddress(), model))
				|| Boolean.FALSE.equals(validation.cityValidation(nVoter.getNriCity(), model))
				|| Boolean.FALSE.equals(validation.nationalityValidation(nVoter.getNriNationality(), model))
				|| Boolean.FALSE.equals(validation.emailValidation(nVoter.getNriEmailId(), model))
				|| Boolean.FALSE.equals(validation.passwordValidation(nVoter.getnUserPassword(), model))
				|| Boolean.FALSE.equals(nVoterDao.emailExist(nVoter, model))
				|| Boolean.FALSE.equals(nVoterDao.voterIdExist(nVoter, model))) {
			
			for (int j = 1; j <=20; j++) {
				if (model.getAttribute("errorMessage" + j) != null) {
					String errorMessage = (String) model.getAttribute("errorMessage" + j);
					model.addAttribute("ErrorMessage", errorMessage);
				}
			}
			return "ErrorPopup.html";
		}
		
		nVoterService.voterNRIregister(nVoter,session);
		
		return "popUpNRIregister.html";
	}
	
	
	@RequestMapping("/loginVoter")
	public String loginVoter(@ModelAttribute("Voter") Voter voter,HttpSession session,Model model) {
		logger.info("Through login controller");
		
		
		
		if(Boolean.TRUE.equals(voterService.voterLoginService(voter, session, model))) {
			return "voterHomepage.html";
		}
		else if(Boolean.FALSE.equals(voterService.voterLoginService(voter, session, model))) {
			return "residentVoter.html";
		}
		return "residentVoter.html";
		
		
	}
	
	//forgot password controller
	@RequestMapping("/forgotPassword")
	public String forgotPasswordPage(@ModelAttribute("forgotPassword") Voter voter) {
		return "forgotPassword.html";
	}
	
	@GetMapping("/dynamicDropdown")
	public String dynamicPartyName(@ModelAttribute("castVote")CastingVote castVote,HttpSession session,Model model) {
		logger.info("List");
		voterDao.gettingElectionDate( model);
		
		List<String>list=voterDao.dynamicPartyName();
		model.addAttribute("dynamic", list);
		
		List<String>eList=voterDao.dynamicElectionName();
		model.addAttribute("dynamicElection", eList);
		
		return "castVote.html";
	}
	
	@GetMapping("/castVote")
	public String castVote(@ModelAttribute("castVote")CastingVote castVote,HttpSession session,Model model) throws AlreadyVotedException {
		
		if (Boolean.FALSE.equals(voterDao.userIdPerVote(castVote,model))) {
			String errorMessage = (String) model.getAttribute("error" );
			model.addAttribute("ErrorMessage", errorMessage);
				
			return "ErrorPopup.html";
		}

		voterService.castVoteService(castVote,session);
		
		return "popUpVoted.html" ;
		
	}
	
	@RequestMapping("/feedbackPage")
	public String feedbackPage(@ModelAttribute("feedback") Voter voter) {
		return "feedbackVoter.html" ;
	}
	
	@GetMapping("/feedback")
	public String userFeedback(@ModelAttribute("feedback") Voter voter) {
		logger.info("Through Controller9");
		
		voterService.feedbackService(voter);
		
		return "popUpFeedback.html" ;
	}
	
	@RequestMapping("/reportPage")
	public String reportPage(@ModelAttribute("report") Voter voter) {
		return "report.html";
	}
	
	@GetMapping("/report")
	public String userComplaints(@ModelAttribute("report") Voter voter) {
		logger.info("Through Controller complaints");
		
		voterService.complaintService(voter);
		
		return "voterHomepage.html";
		
	}
	
	@RequestMapping("/viewUser")
	public  String viewProfile(HttpSession session) {
		logger.info("Through Controller4");
		
		voterService.viewService(session);
		
		return "voterProfile.html";
	}
	
	@RequestMapping("/updatePage")
	public String updatePage(@ModelAttribute("updateDetails") Voter voter,HttpSession session) {
		return "updateVoter.html";
	}
	
	@GetMapping("/updateProfile")
	public String updateProfile(@ModelAttribute("updateDetails") Voter voter,HttpSession session) {
		logger.info("Update profile ");
		
		voterService.updateService( voter, session);
		
		return "voterProfile.html" ;
	}
	
	@RequestMapping("/aboutUs")
	  public String aboutUs() {
		return "aboutUs.html";
		  
	  }
	
	@RequestMapping("/contactUs")
	  public String contactUs() {
		return "contactUs.html";
		  
	  }
	
	//Election delete popup page
	@RequestMapping("/adminElectionHomePage")
	public String electionDeletePage() {
		logger.info("admin Election Page");
		return "adminPage.html";
	}
	
	//candidate delete popup page
	@RequestMapping("/adminDeleteHomePage")
	public String candidateDeletePage() {
		logger.info("admin deleted Page");
		return "adminPage.html";
	}
	
	//register pop up
	@RequestMapping("/voterNRIHomePage")
	public String voterNRIPage() {
		logger.info("Voter NRI Page");
		return "voterNRIhomepage.html";
	}
	
	//administrator login  controller
		@RequestMapping("/admin")
		public String admin(@ModelAttribute("adminObject") Admin admin) {
			return "adminLogin.html";
			
		}
		
	//NRI voter forgot password 
	@GetMapping("/updateNRIPassword")
	public String updatePassword(@ModelAttribute("forgotPassword") NRIVoter nVoter) {
		logger.info("Update profile ");
			
		nVoterService.updatePasswordService(nVoter);
			return "residentNRIvoter.html";	
			
		}

}

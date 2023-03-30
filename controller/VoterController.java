package com.project.evotingsystemspring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.evotingsystemspring.dao.VoterDAO;
import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.myexception.AlreadyVotedException;
import com.project.evotingsystemspring.myexception.DuplicationOfMailException;
import com.project.evotingsystemspring.myexception.DuplicationOfMobileNoException;
import com.project.evotingsystemspring.myexception.InvalidAddressException;
import com.project.evotingsystemspring.myexception.InvalidAgeException;
import com.project.evotingsystemspring.myexception.InvalidCityException;
import com.project.evotingsystemspring.myexception.InvalidDobException;
import com.project.evotingsystemspring.myexception.InvalidEmailIdException;
import com.project.evotingsystemspring.myexception.InvalidGenderException;
import com.project.evotingsystemspring.myexception.InvalidMobileNoException;
import com.project.evotingsystemspring.myexception.InvalidNameException;
import com.project.evotingsystemspring.myexception.InvalidNationalityException;
import com.project.evotingsystemspring.myexception.InvalidPasswordException;
import com.project.evotingsystemspring.myexception.InvalidVoterIdException;
import com.project.evotingsystemspring.service.VoterService;
import com.project.evotingsystemspring.validation.ValidationVs;

@Controller
public class VoterController {
	
	
	VoterDAO voterDao=new VoterDAO();
	
	Voter voter=new Voter();

	VoterService voterService=new VoterService();
	
	 Logger logger = LoggerFactory.getLogger(VoterController.class);
	 
	//handler
	@RequestMapping("/")
	public String home() {
		logger.info("Through Controller");
		return "home.html";
	}
	
	@RequestMapping("/reg")
	public String registerUser(@ModelAttribute("User") Voter voter,HttpSession session) {
		return "registerVoter.html";
	}
	
	@RequestMapping("/registerVoter")
	public String register(@ModelAttribute("User") Voter voter,HttpSession session) throws InvalidAgeException, InvalidEmailIdException, DuplicationOfMailException, InvalidNameException, InvalidDobException, InvalidAddressException, InvalidGenderException, InvalidVoterIdException, InvalidCityException, InvalidNationalityException, InvalidMobileNoException, InvalidPasswordException, DuplicationOfMobileNoException {
		logger.info("Through Controller3");
		
		ValidationVs validation=new ValidationVs();
		
		validation.nameValidation(voter.getVoterName());
		validation.dateOfBirthValidation(voter.getDateOfBirth());
		validation.voterIdValidation(voter.getVoterId());
		validation.fatherNameValidation(voter.getFatherName());
		validation.genderValidation(voter.getGender());
		validation.addressValidation(voter.getAddress());
		validation.cityValidation(voter.getCity());
		validation.nationalityValidation(voter.getNationality());
		validation.phoneNoValidation(voter.getMobileNumber());
		validation.emailValidation(voter.getEmailId());
		validation.passwordValidation(voter.getUserPassword());
		
		voterDao.emailExist(voter);
		voterDao.mobileNoExist(voter);
		
		voterService.voterRegisterService(voter, session);
		
		return "popUpRegister.html";
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
	@RequestMapping("/forgotPassword")
	public String forgotPasswordPage(@ModelAttribute("forgotPassword") Voter voter) {
		return "forgotPassword.html";
	}
	
	@GetMapping("/updatePassword")
	public String updatePassword(@ModelAttribute("forgotPassword") Voter voter) {
		logger.info("Update profile ");
		
		voterService.updatePasswordService(voter);
		return "residentVoter.html";	
		
	}
	
	@GetMapping("/dynamicDropdown")
	public String dynamicPartyName(@ModelAttribute("castVote")CastingVote castVote,HttpSession session,Model model) {
		logger.info("List");
		voterDao.gettingElectionDate( model);
		List<String>list=voterDao.dynamicPartyName();
		model.addAttribute("dynamic", list);
		return "castvote";
	}
	
	@GetMapping("/castVote")
	public String castVote(@ModelAttribute("castVote")CastingVote castVote,HttpSession session,Model model) throws AlreadyVotedException {
		
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
		
		return "voterHomepage.html" ;
	}
	
	@RequestMapping("/aboutUs")
	  public String aboutUs() {
		return "aboutUs.html";
		  
	  }
	
	@RequestMapping("/contactUs")
	  public String contactUs() {
		return "contactUs.html";
		  
	  }
	

}

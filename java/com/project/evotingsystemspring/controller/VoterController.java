package com.project.evotingsystemspring.controller;

import java.sql.Date;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@Autowired
	VoterDAO voterDao;
	@Autowired
	Voter voter;
	@Autowired
	VoterService vService;
	
	 Logger logger = LoggerFactory.getLogger(VoterController.class);
	 
	//handler
	@RequestMapping("/")
	public String home() {
		logger.info("Through Controller");
		return "home";
	}
	
	@PostMapping("/registerVoter")
	public String register(@RequestParam("name") String name, @RequestParam("dob") Date dob,
			@RequestParam("voterId") String voterId,@RequestParam("fatherName") String fname,@RequestParam("gender") String gender,@RequestParam("address") String address,@RequestParam("city") String city,@RequestParam("nationality") String nationality,@RequestParam("mobileNumber") Long mNo,@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session) throws InvalidNameException, InvalidDobException, InvalidAgeException, InvalidVoterIdException, InvalidGenderException, InvalidAddressException, InvalidPasswordException, InvalidEmailIdException, InvalidNationalityException, InvalidCityException, InvalidMobileNoException, DuplicationOfMailException, DuplicationOfMobileNoException {
		logger.info("Through Controller3");
		
		ValidationVs validation=new ValidationVs();
		
		Integer userId=voterDao.generateRandomId();
		voter.setUserId(userId);
		
		validation.nameValidation(name);
		voter.setVoterName(name);
		
		validation.dateOfBirthValidation(dob);
		voter.setDateOfBirth(dob);
		
		Integer age=validation.ageValidation(dob);
		voter.setAge(age);
		
		validation.voterIdValidation(voterId);
		voter.setVoterId(voterId);
		
		validation.fatherNameValidation(fname);
		voter.setFatherName(fname);
		
		validation.genderValidation(gender);
		voter.setGender(gender);
		
		validation.addressValidation(address);
		voter.setAddress(address);
		
		validation.cityValidation(city);
		voter.setCity(city);
		
		validation.nationalityValidation(nationality);
		voter.setNationality(nationality);
		
		validation.phoneNoValidation(mNo);
		voterDao.mobileNoExist(voter);
		voter.setMobileNumber(mNo);
		
		validation.emailValidation(email);
		voterDao.emailExist(voter);
		voter.setEmailId(email);
		
		validation.passwordValidation(password);
		voter.setUserPassword(password);
		
		vService.voterRegisterService(voter, session);
		
		return "popUpRegsiter";
		
	}
	
	
	@PostMapping("/loginVoter")
	public String loginVoter(@RequestParam("voterId") String vId,@RequestParam("password") String password,HttpSession session,Model model) {
		logger.info("Through login controller");
		
		
		voter.setVoterId(vId);
		voter.setUserPassword(password);
		
		if(Boolean.TRUE.equals(vService.voterLoginService(voter, session, model))) {
			return "voterhomepage";
		}
		else if(Boolean.FALSE.equals(vService.voterLoginService(voter, session, model))) {
			return "residentvoter";
		}
		return "residentvoter";
		
		
	}
	
	@PostMapping("/updatePassword")
	public String updatePassword(@RequestParam("email") String id,@RequestParam("password") String password,@RequestParam("password1") String pass) {
		logger.info("Update profile ");
		
		voter.setEmailId(id);
		voter.setUserPassword(password);
		voter.setUserPassword(pass);
		vService.updatePasswordService(voter);
		return "popUpForgot";	
		
	}
	
	@PostMapping("/castVote")
	public String castVote(@RequestParam("electionName") String electionName,@RequestParam("id") String id,@RequestParam("partyName") String pName,@RequestParam("vote") String vote,Model model,
			HttpSession session) throws AlreadyVotedException {
		CastingVote castVote=new CastingVote();
		
		castVote.setElectionType(electionName);
		castVote.setVoterId(id);
		castVote.setPartyName(pName);
		castVote.setVote(vote);

		vService.castVoteService(castVote,session);
		
		return "popUpVoted" ;
		
	}
	
	@PostMapping("/feedback")
	public String userFeedback(@RequestParam("id") Integer id,@RequestParam("feedback") String feedback,@RequestParam("rating") String rate) {
		logger.info("Through Controller9");
		
		voter.setUserId(id);
		voter.setFeedback(feedback);
		voter.setRate(rate);
		
		vService.feedbackService(voter);
		
		return "popUpFeed" ;
	}
	
	@PostMapping("/report")
	public String userComplaints(@RequestParam("id") Integer id,@RequestParam("partyName") String partyName,@RequestParam("complaints") String complaint) {
		logger.info("Through Controller9");
		
		voter.setUserId(id);
		voter.setPartyName(partyName);
		voter.setComplaints(complaint);
		
		vService.complaintService(voter);
		
		return "voterhomepage";
		
	}
	
	@RequestMapping("/viewUser")
	public  String viewProfile(HttpSession session) {
		logger.info("Through Controller4");
		
		vService.viewService(session);
		
		return "viewProfilePage";
	}
	
	@GetMapping("/updateProfile")
	public String updateProfile(@RequestParam("upname") String name,@RequestParam("updob") Date dob,@RequestParam("upvoterId") String vId,@RequestParam("upfatherName") String fName,@RequestParam("address") String address,@RequestParam("city") String city,@RequestParam("mobileNumber") Long mNo,@RequestParam("email") String email,HttpSession session) {
		logger.info("Update profile ");
		
		voter.setVoterName(name);
		voter.setDateOfBirth(dob);
		voter.setVoterId(vId);
		voter.setFatherName(fName);
		voter.setAddress(address);
		voter.setCity(city);
		voter.setMobileNumber(mNo);
		voter.setEmailId(email);
		
		vService.updateService( voter, session);
		
		return "viewProfilePage" ;
	}
	
	
	
	
	

}

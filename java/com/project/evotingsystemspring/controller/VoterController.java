package com.project.evotingsystemspring.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.evotingsystemspring.dao.VoterDAO;
import com.project.evotingsystemspring.model.Voter;
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
import com.project.evotingsystemspring.validation.ValidationVs;

@Controller
public class VoterController {
	
	@Autowired
	VoterDAO voterdao;
	 Logger logger = LoggerFactory.getLogger(VoterController.class);
	 
	//handler
	@RequestMapping("/")
	public String home() {
		logger.info("Through Controller");
		return "JSP/mainPage.jsp";
	}
	
	@RequestMapping("/residentVoter")
	public String resident() {
		logger.info("Through Controller2");
		return "JSP/residentvoter.jsp";
	}
	
	@PostMapping("/registerVoter")
	public String register(@RequestParam("name") String name, @RequestParam("dob") Date dob,
			@RequestParam("voterId") String voterId,@RequestParam("fatherName") String fname,@RequestParam("gender") String gender,@RequestParam("address") String address,@RequestParam("city") String city,@RequestParam("nationality") String nationality,@RequestParam("mobileNumber") Long mNo,@RequestParam("email") String email,@RequestParam("password") String password) throws InvalidNameException, InvalidDobException, InvalidAgeException, InvalidVoterIdException, InvalidGenderException, InvalidAddressException, InvalidPasswordException, InvalidEmailIdException, InvalidNationalityException, InvalidCityException, InvalidMobileNoException, DuplicationOfMailException, DuplicationOfMobileNoException {
		logger.info("Through Controller3");
		
		Voter voter=new Voter();
		ValidationVs validation=new ValidationVs();
		
		Integer userId=voterdao.generateRandomId();
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
		voter.setMobileNumber(mNo);
		voterdao.mobileNoExist(voter);
		
		validation.emailValidation(email);
		voterdao.emailExist(voter);
		voter.setEmailId(email);
		
		validation.passwordValidation(password);
		voter.setUserPassword(password);
		
		voterdao.voterRegister(voter);
		
		return "JSP/voterhomepage.jsp";
		
	}
	
	@PostMapping("/loginVoter")
	public String loginVoter(@RequestParam("voterId") String vId,@RequestParam("password") String password,HttpSession session,Model model) {
		logger.info("Through login controller");
		
		Voter voter=new Voter();
		voter.setVoterId(vId);
		voter.setUserPassword(password);
		
		voterdao.voterLogin(voter,session,model);
		
		if(model.getAttribute("loginstatus").equals("Success")) {
			return "JSP/voterhomepage.jsp";
		}
		else if(model.getAttribute("loginstatus").equals("InvalidCredentials")) {
			return "JSP/residentvoter.jsp";
		}
		return "JSP/residentvoter.jsp";
		
		
	}
	
	@PostMapping("/feedback")
	public String userFeedback(@RequestParam("id") Integer id,@RequestParam("feedback") String feedback) {
		logger.info("Through Controller9");
		Voter voter=new Voter();
		
		voter.setUserId(id);
		voter.setFeedback(feedback);
		
		voterdao.addFeedback(voter);
		
		return "JSP/voterhomepage.jsp" ;
	}
	
	@PostMapping("/report")
	public String userComplaints(@RequestParam("id") Integer id,@RequestParam("partyName") String partyName,@RequestParam("complaints") String complaint) {
		logger.info("Through Controller9");
		Voter voter=new Voter();
		
		voter.setUserId(id);
		voter.setPartyName(partyName);
		voter.setComplaints(complaint);
		
		voterdao.addComplaints(voter);
		
		return "JSP/voterhomepage.jsp";
		
	}
	
	@RequestMapping("/viewUser")
	public  String viewProfile(HttpSession session) {
		logger.info("Through Controller4");
	System.out.println("Through Controller4");
		voterdao.viewProfile(session);
		return "JSP/ViewProfile.jsp";
	}
	
	/*
	 * @GetMapping("/findUserbyId") public String findUserById(@RequestParam("name")
	 * String name, Model model) { System.out.println("finding"); String total =
	 * voterdao.findById(name); System.out.println(total); // if no user found in
	 * the given name, exception if (total.equals(null)) { throw new
	 * EmptyResultDataAccessException(name, 0); } else {
	 * System.out.println("TotalCases:" + total); // setting value in model
	 * attribute to display in jsp model.addAttribute("findId", total); } return
	 * "voterhomepage.jsp"; }
	 */
	
	
	

}

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

import com.project.evotingsystemspring.dao.NRIvoterDAO;
import com.project.evotingsystemspring.dao.VoterDAO;
import com.project.evotingsystemspring.model.NRIVoter;
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
import com.project.evotingsystemspring.validation.ValidationVs;

@Controller
public class NRIvoterController {
	@Autowired
	NRIvoterDAO nVoterDao;
	@Autowired
	VoterDAO voterDao;
	@Autowired
	NRIVoter nVoter;
	@Autowired
	NRIVoterService nService;
	
	 Logger logger = LoggerFactory.getLogger(NRIvoterController.class);
	 
	
	 @PostMapping("/registerNRIVoter")
	public String register(@RequestParam("name") String name,@RequestParam("dob") Date dob,@RequestParam("voterId") String voterId,@RequestParam("fatherName") String fName,@RequestParam("gender") String gender,
			@RequestParam("nationality") String nationality,@RequestParam("state") String state,@RequestParam("city") String city,@RequestParam("email") String email,
			@RequestParam("password") String password,HttpSession session ) throws InvalidNameException, InvalidDobException, InvalidAgeException, InvalidVoterIdException, InvalidGenderException, InvalidCityException, InvalidPasswordException, InvalidNationalityException, InvalidEmailIdException {
		logger.info("Through Controller2");
		
		ValidationVs validation=new ValidationVs();
		
		Integer userId=voterDao.generateRandomId();
		nVoter.setNriId(userId);
		
		validation.nameValidation(name);
		nVoter.setNriVoterName(name);
		
		validation.dateOfBirthValidation(dob);
		nVoter.setNriDateOfBirth(dob);
		
		Integer age=validation.ageValidation(dob);
		nVoter.setNriAge(age);
		
		validation.voterIdValidation(voterId);
		nVoter.setNriVoterId(voterId);
		
		validation.fatherNameValidation(fName);
		nVoter.setNriFatherName(fName);
		
		validation.genderValidation(gender);
		nVoter.setNriGender(gender);
		
		validation.nationalityValidation(nationality);
		nVoter.setNriNationality(nationality);
		
		validation.stateValidation(state);
		nVoter.setNriState(state);
		
		validation.cityValidation(city);
		nVoter.setNriCity(city);
		
		validation.emailValidation(email);
		nVoter.setNriEmailId(email);
		
		validation.passwordValidation(password);
		nVoter.setnUserPassword(password);
		
		nService.voterNRIregister(nVoter,session);
		
		return "popUpNRIregister";
	}
	
	
	
	@PostMapping("/loginNriVoter")
	public String loginVoter(@RequestParam("voterId") String vId,@RequestParam("password") String password,HttpSession session,Model model) {
		logger.info("Through login controller");
		
		nVoter.setNriVoterId(vId);
		nVoter.setnUserPassword(password);
		
		if(Boolean.TRUE.equals(nService.voterNRIlogin(nVoter, session,model))) {
			return "voterNRIhomepage";
		}
		else if(Boolean.FALSE.equals(nService.voterNRIlogin(nVoter, session,model))) {
			return "residentNRIvoter";
		}
		return "residentNRIvoter";
		
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
	
    @RequestMapping("/voterNRIHomePage")
	public String voterNRIPage() {
		logger.info("Voter NRI Page");
		return "voterNRIhomepage";
	}
    
	@PostMapping("/updateNRIPassword")
	public String updatePassword(@RequestParam("email") String id,@RequestParam("password") String password,@RequestParam("password1") String pass) {
		logger.info("Update profile ");
		
		nVoter.setNriEmailId(id);
		nVoter.setnUserPassword(password);
		nVoter.setnUserPassword(pass);
		nService.updatePasswordService(nVoter);
		return "residentvoter";	
		
	}
	
	@RequestMapping("/viewNRIuser")
	public String viewNriProfile(HttpSession session) {
		logger.info("Through Controller4");
		nService.viewService(session);
		return "viewNRIprofilePage";
		
	}
	
	@GetMapping("/updateNRIprofile")
	public String updateProfile(@RequestParam("nupname") String name,@RequestParam("nupdob") Date dob,@RequestParam("nupvoterId") String vId,@RequestParam("nupfatherName") String fName,@RequestParam("state") String state,@RequestParam("city") String city,@RequestParam("email") String email,HttpSession session) {
		logger.info("Update profile ");
		
		nVoter.setNriVoterName(name);
		nVoter.setNriDateOfBirth(dob);
		nVoter.setNriVoterId(vId);
		nVoter.setNriFatherName(fName);
		nVoter.setNriState(state);
		nVoter.setNriCity(city); 
		nVoter.setNriEmailId(email);
		
		nService.updateService(nVoter, session);
		
		return "viewNRIprofilePage" ;
	}
	
	//Candidate
		@RequestMapping("/adminHomePage")
		public String candidatePage() {
			logger.info("admin Add Page");
			return "adminpage";
		}
		
		@RequestMapping("/resetPasswordPage")
		public String resetPasswordPage() {
			logger.info("Password Reset");
			return "residentvoter";
		}
		
		
	
}

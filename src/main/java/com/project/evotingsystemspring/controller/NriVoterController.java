package com.project.evotingsystemspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.evotingsystemspring.dao.NriVoterDAO;
import com.project.evotingsystemspring.dao.VoterDAO;
import com.project.evotingsystemspring.model.NriVoter;
import com.project.evotingsystemspring.model.Voter;

@Controller
public class NriVoterController {
	@Autowired
	NriVoterDAO nd;
	@Autowired
	VoterDAO vd;
	
	@RequestMapping("/nriResidentVoter")
	public String nriResident() {
		System.out.println("Through Controller");
		return "JSP/nri_residentvoter.jsp";
	}
	
	@PostMapping("/registerNriVoter")
	public String register(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("dob") String dob,@RequestParam("age") Integer age,@RequestParam("voterId") String vId,@RequestParam("fatherName") String fName,@RequestParam("gender") String gender,@RequestParam("nationality") String nationality,@RequestParam("state") String state,@RequestParam("city") String city,@RequestParam("email") String email,@RequestParam("password") String password ) {
		System.out.println("Through Controller2");
		NriVoter n=new NriVoter();
		Integer userId=vd.generateRandomId();
		n.setNriId(userId);
		n.setVoterName(name);
		n.setDateOfBirth(dob);
		n.setAge(age);
		n.setVoterId(vId);
		n.setFatherName(fName);
		n.setGender(gender);
		n.setNationality(nationality);
		n.setState(state);
		n.setCity(city);
		n.setEmailId(email);
		n.getUserPassword();
		
		nd.nriVoterRegister(n);
		
		return "JSP/voterhomepage.jsp";
	}
	
	@GetMapping("/viewNriUser")
	public String ViewNriProfile(@RequestParam("id") Integer id,Model model) {
		System.out.println("Through Controller4");
		List<NriVoter> user=nd.viewNriProfile(id);
		Model addAttribute=model.addAttribute("USER_LIST", user);
		return "JSP/viewNriProfile.jsp";
		
	}
}

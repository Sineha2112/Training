package com.project.evotingsystemspring.controller;

import java.util.List;

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

import com.project.evotingsystemspring.dao.AdminDAO;
import com.project.evotingsystemspring.model.Admin;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.model.VoteCount;

@Controller
public class AdminController {
	@Autowired
	AdminDAO admindao;
	
	 Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@PostMapping("/adminLogin")
	public String adminLogin(@RequestParam("adminId") String adminId,@RequestParam("password") String password,HttpSession session,Model model) {
		logger.info("Through Controller");
		Admin admin=new Admin();
		
		admin.setAdminId(adminId);
		admin.setPassword(password);
		
		admindao.adminLogin(admin, session, model);
		
		if(model.getAttribute("loginstatus").equals("Success")) {
			return "/JSP/adminpage.jsp";
		}
		else if(model.getAttribute("loginstatus").equals("InvalidCredentials")) {
			return "JSP/adminlogin.jsp";
		}
		return "JSP/adminpage.jsp";
		
	}
	
	//Candidate
	@PostMapping("/addCandidates")
	public String addCandidate(@RequestParam("electionId") Integer eId,@RequestParam("id") Integer cId,@RequestParam("partyName") String pName,@RequestParam("partySymbol") String pSymbol,@RequestParam("name") String cName,@RequestParam("gender") String gender,@RequestParam("age") Integer age,@RequestParam("address") String address,@RequestParam("city") String city,@RequestParam("nationality") String nationality,@RequestParam("mobileNo") Long mNo,@RequestParam("email") String email,@RequestParam("history") String history) {
		logger.info("Through Controller1");
		Candidate candidate=new Candidate();
		candidate.setElectionId(eId);
		candidate.setCandidateId(cId);
		candidate.setPartyName(pName);
		candidate.setPartySymbol(pSymbol);
		candidate.setCandidateName(cName);
		candidate.setGender(gender);
		candidate.setAge(age);
		candidate.setAddress(address);
		candidate.setCity(city);
		candidate.setNationality(nationality);
		candidate.setMobileNo(mNo);
		candidate.setEmailId(email);
		candidate.setHistory(history);
		admindao.addCandidates(candidate);
		return "JSP/insertCandidates.jsp";	
	}
	
	@PostMapping("/updateCandidates")
	public String updateCandidates(@RequestParam("id") Integer id,@RequestParam("changeData") String data) {
		logger.info("Through Controller2");
		Candidate candidate=new Candidate();
		candidate.setCandidateId(id);
		candidate.setData(data);
		admindao.updateCandidates(candidate);
		return "JSP/updateCandidate.jsp" ;
	}
	
	@PostMapping("/deleteCandidates")
	public String deleteCandidates(@RequestParam("id") Integer id) {
		logger.info("Through Controller2");
		Candidate candidate=new Candidate();
		candidate.setCandidateId(id);
		admindao.deleteCandidates(candidate);
		return "JSP/deletecandidate.jsp";
	}
	
	@PostMapping("/viewCandidates")
	public String viewCandidate(Model model) {
		logger.info("Through Controller3");
		List<Candidate> candidateList=admindao.viewCandidates();
		Model addAttribute=model.addAttribute("CANDIDATE_LIST", candidateList);
		return "JSP/ViewCandidates.jsp";
	}
	
	//Election
	@PostMapping("/addElection")
	public String addElection(@RequestParam("id") Integer id,@RequestParam("name") String eName,@RequestParam("date") String eDate) {
		logger.info("Through Controller4");
		Admin admin=new Admin();
		admin.setElectionId(id);
		admin.setElectionName(eName);
		admin.setElectionDate(eDate);
		admindao.addElection(admin);
		return "JSP/addelection.jsp";
	}
	
	@PostMapping("/deleteElection")
	public String deleteElection(@RequestParam("id") Integer id){
		logger.info("Through Controller5");
		Admin admin=new Admin();
		admin.setElectionId(id);
		admindao.deleteElection(admin);
		return "JSP/deleteElection.jsp";
	}
	
	//voteCount
	
	public String viewResult(Model model) {
		logger.info("Through Controller6");
		List<VoteCount> countList=admindao.viewResult();
		model.addAttribute("COUNT_LIST", countList);
		return "JSP/viewResult";
	}
	
	//totalVoteCount
	@GetMapping("/totalCount")
	public String totalVoteCount(Model model) {
		logger.info("To count the total votes");
		int totalCount=admindao.totalVoteCount(model);
		System.out.println(totalCount);
		model.addAttribute("COUNT", totalCount);
		return "/JSP/adminpage.jsp"; 
	}
}

package com.project.evotingsystemspring.controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.evotingsystemspring.dao.AdminDAO;
import com.project.evotingsystemspring.model.Admin;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.service.AdminService;

@Controller
public class AdminController {
	
	AdminDAO adminDao=new AdminDAO();
	
	Admin admin=new Admin();
	
	Candidate candidate=new Candidate();

	AdminService adminService=new AdminService();
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	
	//admin login
	@GetMapping("/adminLogin")
	public String adminLogin(@ModelAttribute("adminObject") Admin admin,@ModelAttribute("candidateDelete") Candidate candidate,HttpSession session,Model model) {
		logger.info("Through Controller");
		
		if(Boolean.TRUE.equals(adminService.adminLogin(admin, session, model))) {
			
			//Total Vote Count
			logger.info("To count the total votes");
			Integer totalCount=adminDao.totalVoteCount();
			model.addAttribute("VOTE_COUNT", totalCount);
			
			//Total User Count
			logger.info("To count total user count");
			Integer userCount=adminDao.totalUserCount();
			model.addAttribute("USER_COUNT", userCount);
			
			//Total NRI User Count
			logger.info("To count total NRI user count");
			Integer userNRICount=adminDao.totalNRIuserCount();
			model.addAttribute("NRIUSER_COUNT", userNRICount);
			
			//Total Candidate Count
			logger.info("To count total Candidate count");
			Integer candidateCount=adminDao.totalCandidateCount();
			model.addAttribute("CANDIDATE_COUNT", candidateCount);
			
			return "adminPage.html";
			
		}
		else if(Boolean.FALSE.equals(adminService.adminLogin(admin, session, model))) {
			return "adminLogin.html";
		}
		
		
		return "adminLogin.html";
		
	}
	
	//Voter
	@GetMapping("/viewVoter")
	public String viewVoter(Model model) throws JsonProcessingException  {
		logger.info("To View Voter");
		adminService.viewVoterService(model);
		return "gridVoterList.html";
		
	}
	
	//NRI Voter
	@RequestMapping("/viewNRIvoter")
	public String viewNRIvoter(Model model)throws JsonProcessingException  {
		logger.info("To View Voter");
		adminService.viewNRIvoterService(model);
		return "gridNRIvoterList.html";
		
	}
	
	//Voter's Vote Details
	@RequestMapping("/viewVoterVoteDetails")
	public String viewVoterVote(Model model) throws JsonProcessingException{
		logger.info("To View Voter's Vote details");
		adminService.viewVotersVoteService(model);
		return "gridVotersVoteList.html";
		
	}
	
	@RequestMapping("/addCandidatesPage")
	public String addCandidatesPage(@ModelAttribute("addCandidates") Candidate candidate) {
		return "addCandidates.html";
	}
	
	@RequestMapping("/addCandidates")
	public String addCandidate(@RequestParam("canImg") MultipartFile candidateImg,@RequestParam("sImg") MultipartFile symbolImg,@ModelAttribute("addCandidates") Candidate candidate) throws IOException{
		logger.info("Through Controller1");
		
		String file=candidateImg.getOriginalFilename();
		
		try(FileInputStream fin=new FileInputStream("C:\\Users\\sine3351\\eclipse-workspace\\votingSystem\\src\\main\\resources\\static\\CandidateImages\\"+file);){
			byte[] images=fin.readAllBytes();
			candidate.setCandidateImage(images);
		}
		String file1=symbolImg.getOriginalFilename();
		try(FileInputStream fin1=new FileInputStream("C:\\Users\\sine3351\\eclipse-workspace\\votingSystem\\src\\main\\resources\\static\\CandidateImages\\"+file1);){
			byte[] symbolImages=fin1.readAllBytes();
			candidate.setSymbolImage(symbolImages);
		}
		adminService.addCandidateService(candidate);
		
		return "popUpAddCandidates.html";	
	}
	
	//candidates delete 
	
	@GetMapping("/candidatesDeletePage")
	public String candidateDeletePage(@ModelAttribute("candidateDelete") Candidate candidate,Model model) throws JsonProcessingException {
		adminDao.gridListCandidates(model);
		return "deleteCandidate.html";
	}
	
	@GetMapping("/deleteCandidates")
	public String deleteCandidates(@ModelAttribute("candidateDelete") Candidate candidate,Model model) {
		logger.info("Through Controller2");
		adminService.deleteCandidateService(candidate);
		return "popUpCandidateDelete.html";
	}
	
	@RequestMapping("/viewCandidates")
	public String viewCandidate(Model model)  {
		logger.info("Through Controller3");
		adminService.viewCanService(model);
		return "ViewCandidates";
	}
	
	@RequestMapping("/reportCandidatePage")
	public String reportCandidatePage(@ModelAttribute("reportsOfCandidates") Admin admin) {
		return "reportsAboutCandidates.html";
	}
	
	@GetMapping("/reportsOfCandidate")
	public String reportOfCandidate(@ModelAttribute("reportsOfCandidates") Admin admin) {
		logger.info("To report candidate about their asset details");
		
		adminService.reportOfCandidateService(admin);
		
		return "popUpReport.html";
	}
	
	//Election
	@RequestMapping("/electionPage")
	public String addElectionPage(@ModelAttribute("addElection") Admin admin) {
		return "addElection.html";
	}
	
	@GetMapping("/addElection")
	public String addElection(@ModelAttribute("addElection") Admin admin) {
		logger.info("Through Controller4");
		
		adminService.addElectionService(admin);
		return "adminPage.html";
	}
	
	//delete election
	@RequestMapping("/deleteElectionPage")
	public String deleteElectionPage(@ModelAttribute("delete") Admin admin) {
		return "deleteElection.html";
	}
	
	@GetMapping("/deleteElection")
	public String deleteElection(@ModelAttribute("delete") Admin admin){
		logger.info("Through Controller5");
		
		adminService.deleteElectionService(admin);
		return "popUpCandidateDelete.html";
	}
	
	@RequestMapping("/viewElection")
	public String viewElection(Model model)throws JsonProcessingException {
		logger.info("To view Election list");
		adminService.viewElection(model);
		return "gridElectionList.html";
		
	}
	
	//Feedback list
	@RequestMapping("/feedbackList")
	public String feedbackList(Model model)throws JsonProcessingException  {
		logger.info("To view Feedback List");
		adminService.viewFeedbackService(model);
		return "gridFeedbackList.html";
		
	}
	
	//Report List
	@RequestMapping("/reportList")
	public String reportList(Model model) throws JsonProcessingException {
		logger.info("To view Feedback List");
		adminService.viewReportService(model);
		return "gridReportList.html";
	}
	
	//view result
	@RequestMapping("/electionResult")
	public String viewResult(Model model) {
		logger.info("Through Controller6");
		adminService.viewResultService(model);
		return "viewResult.html";
	}
	
	//separate Vote Count
	  @RequestMapping("/voteCount")
		public String voteCount(Model model) {
		  
		  adminService.voteCountService(model); 
		  adminDao.separateVoteCount(model);
		  return "voteCount";
			
		}
	  
	  //voter register popup page
	  @RequestMapping("/voterHomePage")
		public String voterPage() {
			logger.info("Voter Register Page");
			return "voterHomepage.html";
		}
		
	  //voter feedback popup return page
	  @RequestMapping("/voterFeedPage")
		public String voterFeedPage() {
			logger.info("Voter Feedback Page");
			return "voterHomepage.html";
		}
	  
	  //NRI feedback popup return page
	  @RequestMapping("/voterNRIhomepageFeedback")
		public String voterNRIFeedPage() {
			logger.info("Voter NRI Feedback Page");
			return "voterNRIhomepage.html";
		}

	  @RequestMapping("/percentage")
	  public String votePercentage(Model model) {
		 Float percentage=(float) Math.round(adminDao.votePercentageCalculation());
		 model.addAttribute("VoterPercentage", adminDao.totalVoteCount());
		 
		 Float nriPercent=(float) Math.round(adminDao.voteNRIPercentageCalculation());
		 model.addAttribute("NRIvoterPercentage", adminDao.totalNRIuserCount());
		 
		 Float resPercent=(float) Math.round(adminDao.voterResidentPercentageCalculation());
		 model.addAttribute("ResidentPercentage", adminDao.totalUserCount());
		 
		 logger.info("Percentage:"+percentage);
		 logger.info("Percentage of NRI User:"+nriPercent);
		 logger.info("Percentage of Resident User"+resPercent);
		 
		return "percentageOfVoter.html" ;
	  }
	  
	 
	 
}

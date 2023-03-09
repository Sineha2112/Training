package com.project.evotingsystemspring.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
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
import org.springframework.web.multipart.MultipartFile;

import com.project.evotingsystemspring.dao.AdminDAO;
import com.project.evotingsystemspring.model.Admin;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	AdminDAO adminDao;
	@Autowired
	Admin admin;
	@Autowired
	Candidate candidate;
	@Autowired
	AdminService aService;
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	 //administrator login
	@PostMapping("/adminLogin")
	public String adminLogin(@RequestParam("adminId") String adminId,@RequestParam("password") String password,HttpSession session,Model model) {
		logger.info("Through Controller");
		
		admin.setAdminId(adminId);
		admin.setPassword(password);
		
		
		
		if(Boolean.TRUE.equals(aService.adminLogin(admin, session, model))) {
			
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
			
			return "adminpage";
			
		}
		else if(Boolean.FALSE.equals(aService.adminLogin(admin, session, model))) {
			return "adminlogin";
		}
		
		
		return "adminlogin";
		
	}
	
	//Voter
	@RequestMapping("/viewVoter")
	public String viewVoter(Model model) {
		logger.info("To View Voter");
		aService.viewVoterService(model);
		return "viewVoter";
		
	}
	
	//NRI Voter
	@RequestMapping("/viewNRIvoter")
	public String viewNriVoter(Model model) {
		logger.info("To View Voter");
		aService.viewNRIvoterService(model);
		return "viewNRIvoter";
		
	}
	
	//Voter's Vote Details
	@RequestMapping("/viewVoterVoteDetails")
	public String viewVoterVote(Model model) {
		logger.info("To View Voter's Vote details");
		aService.viewVotersVoteService(model);
		return "viewVotersVoteDetails";
		
	}
	
	
	@PostMapping("/addCandidates")
	public String addCandidate(@RequestParam("canImg") MultipartFile cImg,@RequestParam("sImg") MultipartFile sImg,@RequestParam("eid") Integer eId,@RequestParam("canId") Integer cId,@RequestParam("canPartyName") String pName,@RequestParam("canPartySymbol") String pSymbol,@RequestParam("canName") String cName,@RequestParam("gender") String gender,@RequestParam("canAge") Integer age,@RequestParam("canAaddress") String address,@RequestParam("canCity") String city,@RequestParam("canNationality") String nationality,@RequestParam("mobileNumber") Long mNo,@RequestParam("canEmail") String email,
			@RequestParam("history") String history)throws IOException {
		logger.info("Through Controller1");
		
		String fileName = cImg.getOriginalFilename();
		try(FileInputStream fin = new FileInputStream("C:\\Users\\sine3351\\eclipse-workspace\\votingSystem\\src\\main\\webapp\\CandidateImages\\"+fileName);){
		
	    byte[] images = fin.readAllBytes(); 
	    candidate.setCandidateImage(images);
		}
		
	    String fileName1 = sImg.getOriginalFilename();
	    try(FileInputStream fin1 = new FileInputStream("C:\\Users\\sine3351\\eclipse-workspace\\votingSystem\\src\\main\\webapp\\CandidateImages\\"+fileName1);){
	    	byte[] images1 = fin1.readAllBytes(); 
	    	candidate.setSymbolImage(images1);
	    }
	    
	    
		
		
		candidate.setElectionId(eId);
		candidate.setCandidateId(cId);
		candidate.setCanPartyName(pName);
		candidate.setCanPartySymbol(pSymbol);
		candidate.setCandidateName(cName);
		candidate.setCanGender(gender);
		candidate.setCanAge(age);
		candidate.setCanAddress(address);
		candidate.setCanCity(city);
		candidate.setCanNationality(nationality);
		candidate.setCanMobileNo(mNo);
		candidate.setCanEmailId(email);
		candidate.setHistory(history);
		
		aService.addCandidateService(candidate);
		
		return "popUpCandidates";	
	}
	
	@PostMapping("/updateCandidates")
	public String updateCandidates(@RequestParam("id") Integer id,@RequestParam("changeData") String data) {
		logger.info("Through Controller2");
		
		candidate.setCandidateId(id);
		candidate.setData(data);
		aService.updateCandidateService(candidate);
		return "updateCandidate" ;
	}
	
	@RequestMapping("/adminDeleteHomePage")
	public String canDeletePage() {
		logger.info("admin deleted Page");
		return "adminpage";
	}
	
	@PostMapping("/deleteCandidates")
	public String deleteCandidates(@RequestParam("id") Integer id) {
		logger.info("Through Controller2");
		
		candidate.setCandidateId(id);
		aService.deleteCandidateService(candidate);
		return "popUpdeleteCan";
	}
	
	@RequestMapping("/viewCandidates")
	public String viewCandidate(Model model) {
		logger.info("Through Controller3");
		aService.viewCanService(model);
		return "ViewCandidates";
	}
	
	@GetMapping("/reportsOfCandidate")
	public String reportOfCandidate(@RequestParam("id") Integer cId,@RequestParam("aValue") Integer assetValue,@RequestParam("pValue")Integer pAssetValue,@RequestParam("report") String report) {
		logger.info("To report candidate about their asset details");
		
		admin.setCandidateName(cId);
		admin.setAssetValue(assetValue);
		admin.setPastAssetValue(pAssetValue);
		admin.setReportOfCandidate(report);
		
		aService.reportOfCandidateService(admin);
		
		return "popUpReport";
	}
	
	//Election
	@PostMapping("/addElection")
	public String addElection(@RequestParam("id") Integer id,@RequestParam("name") String eName,@RequestParam("Date") Date eDate) {
		logger.info("Through Controller4");
		
		admin.setElectionId(id);
		admin.setElectionName(eName);
		admin.setElectionDate(eDate);
		aService.addElectionService(admin);
		return "addelection";
	}
	
	@PostMapping("/deleteElection")
	public String deleteElection(@RequestParam("id") Integer id){
		logger.info("Through Controller5");
		
		admin.setElectionId(id);
		aService.deleteElectionService(admin);
		return "deleteElection";
	}
	
	@RequestMapping("/viewElection")
	public String viewElection(Model model) {
		logger.info("To view Election list");
		aService.viewElection(model);
		return "viewElection";
		
	}
	
	//Feedback list
	@RequestMapping("/feedbackList")
	public String feedbackList(Model model) {
		logger.info("To view Feedback List");
		aService.viewFeedbackService(model);
		return "feedbackList";
		
	}
	
	//Report List
	@RequestMapping("/reportList")
	public String reportList(Model model) {
		logger.info("To view Feedback List");
		aService.viewReportService(model);
		return "reportList";
	}
	
	//view result
	@RequestMapping("/electionResult")
	public String viewResult(Model model) {
		logger.info("Through Controller6");
		aService.viewResultService(model);
		return "viewResult";
	}
	
	//separate Vote Count
	  @RequestMapping("/voteount")
		public String voteCount(Model model) {
		  
		  aService.voteCountService(model); 
		  adminDao.separateVoteCount(model);
		  return "voteCount";
			
		}
	  
	  @RequestMapping("/voterHomePage")
		public String voterPage() {
			logger.info("Voter Register Page");
			return "voterhomepage";
		}
		
	  @RequestMapping("/voterFeedPage")
		public String voterFeedPage() {
			logger.info("Voter Feedback Page");
			return "voterhomepage";
		}

	  @RequestMapping("/percentage")
	  public String votePercentage(Model model) {
		 Float percentage=adminDao.votePercentageCalculation();
		 model.addAttribute("VoterPercentage", percentage);
		 
		 Float percent=adminDao.voteNRIPercentageCalculation();
		 model.addAttribute("NRIvoterPercentage", percent);
		 
		 logger.info("Percentage:"+percentage);
		 logger.info("Percentage of NRI User:"+percent);
		 
		return "percentageOfVoter" ;
	  }
	  
	  //Searching process
	  @RequestMapping("/searchList")
	  public String search(@RequestParam("search") String searchData,Model model) {
		 List<Voter> searchList=aService.searchService(searchData);
		 model.addAttribute("SEARCHDATA", searchList);
		 if(searchList.isEmpty()) {
			 return "popUpNotFound";
		 }
		return "voterSearchList";  
	  }
	  
	  @RequestMapping("/searchNRIList")
	  public String searchNRIlist(@RequestParam("search") String searchNRIData,Model model) {
		 List<NRIVoter> searchList=aService.searchNRIService(searchNRIData);
		 model.addAttribute("SEARCHDATA", searchList);
		 if(searchList.isEmpty()) {
			 return "popUpNotFound";
		 }
		return "searchNRIList";
		  
		  
	  }
}

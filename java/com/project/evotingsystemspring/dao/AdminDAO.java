package com.project.evotingsystemspring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.evotingsystemspring.connection.ConnectionUtil;
import com.project.evotingsystemspring.daointerface.AdminInterface;
import com.project.evotingsystemspring.mapper.AdminMapper;
import com.project.evotingsystemspring.mapper.CandidateMapper;
import com.project.evotingsystemspring.mapper.ElectionMapper;
import com.project.evotingsystemspring.mapper.FeedbackMapper;
import com.project.evotingsystemspring.mapper.NRIvoterMapper;
import com.project.evotingsystemspring.mapper.PartyNameMapper;
import com.project.evotingsystemspring.mapper.ReportMapper;
import com.project.evotingsystemspring.mapper.VoteCountMapper;
import com.project.evotingsystemspring.mapper.VoterMapper;
import com.project.evotingsystemspring.mapper.VoterVoteDetailsMapper;
import com.project.evotingsystemspring.mapper.CandidateGridMapper;
import com.project.evotingsystemspring.model.Admin;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.VoteCount;
import com.project.evotingsystemspring.model.Voter;

@RestController
public class AdminDAO implements AdminInterface {
	
	JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	Logger logger = LoggerFactory.getLogger(AdminDAO.class);

	Admin admin=new Admin();
	
	//Admin Login
	public Boolean adminLogin(Admin admin, HttpSession session, Model model) {
		logger.info("To Login Admin");
		String status;
		String aId = admin.getAdminId();
		String pass = admin.getPassword();
			String query = "select admin_name,admin_id,admin_password from Admin ";
			List<Admin> userList = jdbcTemplate.query(query, new AdminMapper());
			for (Admin adminli : userList) {
				if (adminli != null) {
					String adminId = adminli.getAdminId();
					if (aId.equals(adminId)) {
						String aPass = adminli.getPassword();
						if (pass.equals(aPass)) {
							status = "Success";
							String name = adminli.getAdminName();
							session.setAttribute("adminName", name);
							model.addAttribute("loginstatus", status);
							return true;
						}
					
					} else {
						logger.info("Invalid Password");
						status = "InvalidCredentials";
						model.addAttribute("invalidLoginstatus", status);
						return false;
					}
				}
				status = "InvalidCredentials";
				model.addAttribute("invalidLoginstatus", status);
			}
			return false;

	}

	// Voter List
	public void viewVoter(Model model) throws JsonProcessingException {
		String sql = "select user_id,voter_name,date_of_birth,age,voter_id,father_name,gender,address,city,nationality,mobileNumber,email_id from ResidentVoter";
		List<Voter> voterList = jdbcTemplate.query(sql, new VoterMapper());
	
		List<Map<String,Object>> voterListGrid=new ArrayList<>();
		for (Voter vList : voterList) {
			Map<String,Object> list=new HashMap<>();
			list.put("userCode", vList.getUserId());
			list.put("voterName", vList.getVoterName());
			list.put("dob", vList.getDateOfBirth());
			list.put("age", vList.getAge());
			list.put("voterId", vList.getVoterId());
			list.put("fatherName", vList.getFatherName());
			list.put("gender", vList.getGender());
			list.put("address", vList.getAddress());
			list.put("city", vList.getCity());
			list.put("nationality", vList.getNationality());
			list.put("mobileNo", vList.getMobileNumber());
			list.put("emailId", vList.getEmailId());
			
			voterListGrid.add(list);
			
		}
		ObjectMapper voterList1=new ObjectMapper();
		String voterLi=voterList1.writeValueAsString(voterListGrid);
		model.addAttribute("voterList", voterLi);
	}

	//NRI Voter List
	public void viewNRIvoter(Model model) throws JsonProcessingException {
		String sql = "select nri_id,voter_name,date_of_birth,age,voter_id,father_name,gender,nationality,address,city,email_id from NonResidentVoter";
		List<NRIVoter> voterList = jdbcTemplate.query(sql, new NRIvoterMapper());
		List<Map<String,Object>> voterNRIlistGrid=new ArrayList<>();
		for (NRIVoter nList : voterList) {
			Map<String,Object> list=new HashMap<>();
			list.put("NRIuserCode", nList.getNriId());
			list.put("voterName", nList.getNriVoterName());
			list.put("dob", nList.getNriDateOfBirth());
			list.put("age", nList.getNriAge());
			list.put("voterNRIId", nList.getNriVoterId());
			list.put("fatherName", nList.getNriFatherName());
			list.put("gender", nList.getNriGender());
			list.put("nationality", nList.getNriNationality());
			list.put("state", nList.getNriAddress());
			list.put("city", nList.getNriCity());
			list.put("emailId", nList.getNriEmailId());
			
			voterNRIlistGrid.add(list);
			
		}
		ObjectMapper voterNRIList=new ObjectMapper();
		String voterNRILi=voterNRIList.writeValueAsString(voterNRIlistGrid);
		model.addAttribute("voterNRIlist", voterNRILi);
		
	}

	//Voter's Vote Details
	public void viewVoterVoteDetails(Model model) throws JsonProcessingException {
		String sql = "select election_type,voter_id,party_name,vote from CastingVote";
		List<CastingVote> voteList = jdbcTemplate.query(sql, new VoterVoteDetailsMapper());
		List<Map<String,Object>> voterVoteListGrid=new ArrayList<>();
		for (CastingVote voteGridList : voteList) {
			Map<String,Object> list=new HashMap<>();
			list.put("voterId", voteGridList.getVoterId());
			list.put("electionType", voteGridList.getElectionType());
			list.put("partyName", voteGridList.getPartyName());
			list.put("voted", voteGridList.getVote());
			
			voterVoteListGrid.add(list);
			
		}
		ObjectMapper voteList1=new ObjectMapper();
		String voteLi=voteList1.writeValueAsString(voterVoteListGrid);
		model.addAttribute("voterVotelist", voteLi);
		
	}

	// Candidate
	public void addCandidates(Candidate candidate) {
		logger.info("To Insert Candidates");
		String query = "insert into Candidate(candidateImg,symbolmg,election_id,candidate_id,party_name,party_symbol,candidate_name,gender,age,address,city,nationality,mobileNo,emailId,history) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] insert = {candidate.getCandidateImage(),candidate.getSymbolImage(), candidate.getElectionId(), candidate.getCandidateId(), candidate.getCandidatePartyName(), candidate.getCandidatePartySymbol(),
				candidate.getCandidateName(), candidate.getCandidateGender(), candidate.getCandidateAge(), candidate.getCandidateAddress(), candidate.getCandidateCity(), candidate.getCandidateNationality(),
				candidate.getCandidateMobileNo(), candidate.getCandidateEmailId(), candidate.getHistory() };
		jdbcTemplate.update(query, insert);
		logger.info("Candidate Inserted" );
	}

	public void deleteCandidates(Candidate candidate) {
		Integer id=candidate.getCandidateId();
		logger.info("Delete Candidate Details");
		String query = "delete from Candidate where candidate_id=?";
		Object[] dlt = {id };
	 jdbcTemplate.update(query, dlt);
		logger.info("Candidate Deleted" );
	}

	public List<Candidate> viewCandidates()  {
		String sql = "select candidateImg,symbolmg,election_id,candidate_id,party_name,party_symbol,candidate_name,gender,age,address,city,nationality,mobileNo,emailId,history from Candidate where party_name not in 'NOTA'";
		List<Candidate> candidateList = jdbcTemplate.query(sql, new CandidateMapper());
		logger.info(candidateList + "candidate records");
		return candidateList;
	}
	
	public void gridListCandidates(Model model) throws JsonProcessingException {
	
	 String sql = "select election_id,candidate_id,party_name,candidate_name,gender,age,address,city,nationality,mobileNo,emailId from Candidate where party_name not in 'NOTA'";
	 List<Candidate> candidateList = jdbcTemplate.query(sql, new CandidateGridMapper());
	 List<Map<String,Object>> candidateListGrid=new ArrayList<>();
	 for (Candidate gridList : candidateList) {
			Map<String,Object> list=new HashMap<>();
			list.put("ElectionCode", gridList.getElectionId());
			list.put("CandidateCode", gridList.getCandidateId());
			list.put("PartyName", gridList.getCandidatePartyName());
			list.put("Name", gridList.getCandidateName());
			list.put("CandidateGender", gridList.getCandidateGender());
			list.put("age", gridList.getCandidateAge());
			list.put("Address", gridList.getCandidateAddress());
			list.put("city", gridList.getCandidateCity());
			list.put("Nationality", gridList.getCandidateNationality());
			list.put("MobileNumber", gridList.getCandidateMobileNo());
			list.put("CandidateEmailId", gridList.getCandidateEmailId());
		
			
			candidateListGrid.add(list);
			
	 }
	 ObjectMapper candidateList1=new ObjectMapper();
	 String candidateLi=candidateList1.writeValueAsString(candidateListGrid);
	 model.addAttribute("candidateGrid", candidateLi);
	}

	// Election
	public void addElection(Admin a) {
		logger.info("To Add Election");
		String query = "insert into Election(election_id,election_type,election_date)values (?,?,?)";
		Object[] insert = { a.getElectionId(), a.getElectionName(), a.getElectionDate() };
		jdbcTemplate.update(query, insert);
		logger.info("Election Inserted" );
	}

	public void deleteElection(Admin a) {
		logger.info("Delete Election");
		String query = "delete from Election where election_id=?";
		Object[] dlt = { a.getElectionId() };
		jdbcTemplate.update(query, dlt);
		logger.info("Election Deleted");
	}

	public List<Admin> viewElection(Model model) throws JsonProcessingException {
		logger.info("View Election");
		String sql = "select election_id,election_type,election_date from Election";
		List<Admin> electionList = jdbcTemplate.query(sql, new ElectionMapper());
		List<Map<String,Object>> electionListGrid=new ArrayList<>();
		for (Admin gridList : electionList) {
			Map<String,Object> list=new HashMap<>();
			list.put("electionCode", gridList.getElectionId());
			list.put("electionName", gridList.getElectionName());
			list.put("electionDate", gridList.getElectionDate());
			
			electionListGrid.add(list);
			
		}
		ObjectMapper election=new ObjectMapper();
		String electionLi=election.writeValueAsString(electionListGrid);
		model.addAttribute("ElectionList", electionLi);
		return electionList;
	}

	// Feedback list
	public void viewFeedback(Model model) throws JsonProcessingException {
		logger.info("View Feedback");
		String sql = "select user_id,feedback,rating from Feedback";
		List<Voter> feedbackList = jdbcTemplate.query(sql, new FeedbackMapper());
		List<Map<String,Object>> feedbackListGrid=new ArrayList<>();
		for (Voter gridList : feedbackList) {
			Map<String,Object> list=new HashMap<>();
			list.put("VoterCode", gridList.getUserId());
			list.put("feedback", gridList.getFeedback());
			list.put("rate", gridList.getRate());
			
			feedbackListGrid.add(list);
			
		}
		ObjectMapper feedback=new ObjectMapper();
		String feedbackLi=feedback.writeValueAsString(feedbackListGrid);
		model.addAttribute("FeedbackList", feedbackLi);
	}

	// Voter's Report
	public List<Voter> viewReports(Model model) throws JsonProcessingException {
		logger.info("View Reports");
		String sql = "select user_id,party_name,complaints from usercomplaints";
		List<Voter> reportList = jdbcTemplate.query(sql, new ReportMapper());
		List<Map<String,Object>> reportListGrid=new ArrayList<>();
		for (Voter gridList : reportList) {
			Map<String,Object> list=new HashMap<>();
			list.put("userCode", gridList.getUserId());
			list.put("PartyName", gridList.getPartyName());
			list.put("Complaints", gridList.getComplaints());
			
			reportListGrid.add(list);
			
		}
		ObjectMapper report=new ObjectMapper();
		String reportLi=report.writeValueAsString(reportListGrid);
		model.addAttribute("ReportList", reportLi);
	
		return reportList;
	}

	// Maximum Vote count
	public List<VoteCount> viewResult(Model model) {
		String sql = "select distinct party_name,count from VoteCount where count=(select Max(count) from voteCount)";
		List<VoteCount> countList = jdbcTemplate.query(sql, new VoteCountMapper());
		
		String result="select distinct party_name,count from VoteCount";
		List<VoteCount> resultList = jdbcTemplate.query(result, new VoteCountMapper());
		model.addAttribute("ResultList", resultList);
		logger.info(countList + "result records");
		return countList;
	}

	public Integer voteCount(Model model) {
		String query="select distinct party_name from Candidate";
		List<Candidate> partyName= jdbcTemplate.query(query,new PartyNameMapper());
		model.addAttribute("PARTYNAME", partyName);
		logger.info(partyName + "count records");
		
		Integer count=0;
		String name = null;
		
		for (Candidate candidate : partyName) {
			 name=candidate.getCandidatePartyName();
		
		String query1 = "select count(party_name) from CastingVote where party_name=?";
		 count= jdbcTemplate.queryForObject(query1, Integer.class,name);
		 
		String insert="insert into voteCount(party_name,count) values (?,?)";
		Object[] ins= {name,count};
		jdbcTemplate.update(insert, ins);
		logger.info("Count Inserted ");
		}
		return count;
	}
	
	//separate vote count
	public List<VoteCount> separateVoteCount(Model model) {
		String query1="select DISTINCT (party_name),count from voteCount";
		List<VoteCount> countList=jdbcTemplate.query(query1,new VoteCountMapper());
		model.addAttribute("COUNTLIST", countList);
		return countList;
		
	}


	// Total vote count
	public Integer totalVoteCount() {
		String sql = "SELECT COUNT(*) FROM CastingVote";
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}

	//Total user count
	public Integer totalUserCount() {
		String sql = "SELECT COUNT(*) FROM ResidentVoter";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	//Total NRI user count
	public Integer totalNRIuserCount() {
		String sql = "SELECT COUNT(*) FROM NonResidentVoter";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	//total candidate count
	public Integer totalCandidateCount() {
		String sql = "SELECT COUNT(*) FROM Candidate";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	

	// Expense calculation
	public void expenseCalculate(Admin admin) {
		int assetValue = admin.getAssetValue();
		int pAssetValue = admin.getPastAssetValue();
		if (assetValue <= pAssetValue) {
			logger.info("Eligible for the election");
			String query = "insert into adminReport(candidate_name,party_name,report_about_candidate) values(?,?,?)";
			Object[] reg = { admin.getCandidateName(),admin.getPartyName(), admin.getReportOfCandidate() };
			jdbcTemplate.update(query, reg);
			logger.info("Report Inserted");
		} 
		else {
			logger.info("Not eligible for the election");
		} 
	}

	// Crimial records(if the candidate is in jail for more than 4 years and apply
	// for election within that year they cannot apply(they can apply after 5
	// Years))
	public boolean criminalRecords(Candidate candidate) {

		Integer pDuration=candidate.getYearsOfPunishment(); 
		Integer rYear=candidate.getReleasedYear();
		
		return Optional.ofNullable(pDuration)
	               .map(u -> {
	                   if (pDuration >4 && rYear<5)  {
	                       logger.info("You Can't Apply for Election For 5 Years");
	                       return true;
	                   } else {
	                       logger.info("You Can Apply for Election");
	                       return false;
	                   }
	               })
	               .orElse(false);
	}
	
	public Float votePercentageCalculation() {
		Integer totalCount=totalVoteCount();
		
		Integer userCount=totalUserCount();
		Integer nriCount=totalNRIuserCount();
		Integer total=userCount+nriCount;
		
		return (totalCount.floatValue()/total.floatValue())*100;
	}
	
	public float voteNRIPercentageCalculation() {
		Integer totalCount=totalVoteCount();
		Integer userNRICount=totalNRIuserCount();
		return (totalCount.floatValue()/userNRICount.floatValue())*100;
	}
	
	public float voterResidentPercentageCalculation() {
		Integer totalCount=totalVoteCount();
		Integer userCount=totalUserCount();
		return (totalCount.floatValue()/userCount.floatValue())*100;
	}
	


	
	
}

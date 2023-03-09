package com.project.evotingsystemspring.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import com.project.evotingsystemspring.daointerface.AdminInterface;
import com.project.evotingsystemspring.mapper.AdminMapper;
import com.project.evotingsystemspring.mapper.CandidateMapper;
import com.project.evotingsystemspring.mapper.ElectionMapper;
import com.project.evotingsystemspring.mapper.FeedbackMapper;
import com.project.evotingsystemspring.mapper.NriVoterMapper;
import com.project.evotingsystemspring.mapper.PartyNameMapper;
import com.project.evotingsystemspring.mapper.ReportMapper;
import com.project.evotingsystemspring.mapper.SearchListMapper;
import com.project.evotingsystemspring.mapper.SearchListNRIMapper;
import com.project.evotingsystemspring.mapper.VoteCountMapper;
import com.project.evotingsystemspring.mapper.VoterMapper;
import com.project.evotingsystemspring.mapper.VoterVoteDetailsMapper;
import com.project.evotingsystemspring.model.Admin;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.VoteCount;
import com.project.evotingsystemspring.model.Voter;

@Repository
@RestController
public class AdminDAO implements AdminInterface {
	@Autowired
	JdbcTemplate jdbctemplate;
	
	Logger logger = LoggerFactory.getLogger(AdminDAO.class);

	Admin admin=new Admin();
	
	//Admin Login
	public Boolean adminLogin(Admin admin, HttpSession session, Model model) {
		logger.info("To Login Admin");
		String status;
		String aId = admin.getAdminId();
		String pass = admin.getPassword();
			String query = "select admin_name,admin_id,admin_password from Admin ";
			List<Admin> userList = jdbctemplate.query(query, new AdminMapper());
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
	public List<Voter> viewVoter() {
		String sql = "select user_id,voter_name,date_of_birth,age,voter_id,father_name,gender,address,city,nationality,mobileNumber,email_id from ResidVoter";
		List<Voter> voterList = jdbctemplate.query(sql, new VoterMapper());
		logger.info(voterList + "voter records");
		return voterList;
	}

	//NRI Voter List
	public List<NRIVoter> viewNriVoter() {
		String sql = "select nri_id,voter_name,date_of_birth,age,voter_id,father_name,gender,nationality,state,city,email_id from NRIVoter";
		List<NRIVoter> voterList = jdbctemplate.query(sql, new NriVoterMapper());
		logger.info(voterList + "NRI voter records");
		return voterList;
	}

	//Voter's Vote Details
	public List<CastingVote> viewVoterVoteDetails() {
		String sql = "select election_type,voter_id,party_name,vote from CastingVote";
		List<CastingVote> voterList = jdbctemplate.query(sql, new VoterVoteDetailsMapper());
		logger.info(voterList + "Vote details records");
		return voterList;
	}

	// Candidate
	public void addCandidates(Candidate c) {
		logger.info("To Insert Candidates");
		String query = "insert into Candidate(candidateImg,symbolmg,election_id,candidate_id,party_name,party_symbol,candidate_name,gender,age,address,city,nationality,mobileNo,emailId,history) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] insert = {c.getCandidateImage(),c.getSymbolImage(), c.getElectionId(), c.getCandidateId(), c.getCanPartyName(), c.getCanPartySymbol(),
				c.getCandidateName(), c.getCanGender(), c.getCanAge(), c.getCanAddress(), c.getCanCity(), c.getCanNationality(),
				c.getCanMobileNo(), c.getCanEmailId(), c.getHistory() };
		jdbctemplate.update(query, insert);
		logger.info("Candidate Inserted" );
	}

	public int updateCandidates(Candidate c) {
		logger.info("Update Candidate Details");
		String query = "update Candidate set candidate_name=? where candidate_id=?";
		Object[] up = { c.getData(), c.getCandidateId() };
		int rows = jdbctemplate.update(query, up);
		logger.info("Candidate Updated:" + rows);
		return rows;

	}

	public void deleteCandidates(Candidate c) {
		logger.info("Delete Candidate Details");
		String query = "delete from Candidate where candidate_id=?";
		Object[] dlt = { c.getCandidateId() };
	 jdbctemplate.update(query, dlt);
		logger.info("Candidate Deleted" );
	}

	public List<Candidate> viewCandidates() {
		String sql = "select candidateImg,symbolmg,election_id,candidate_id,party_name,party_symbol,candidate_name,gender,age,address,city,nationality,mobileNo,emailId,history from Candidate";
		List<Candidate> candidateList = jdbctemplate.query(sql, new CandidateMapper());
		logger.info(candidateList + "candidate records");
		return candidateList;
	}

	// Election
	public void addElection(Admin a) {
		logger.info("To Add Election");
		String query = "insert into Election(election_id,election_type,election_date)values (?,?,?)";
		Object[] insert = { a.getElectionId(), a.getElectionName(), a.getElectionDate() };
		jdbctemplate.update(query, insert);
		logger.info("Election Inserted" );
	}

	public void deleteElection(Admin a) {
		logger.info("Delete Election");
		String query = "delete from Election where election_id=?";
		Object[] dlt = { a.getElectionId() };
		jdbctemplate.update(query, dlt);
		logger.info("Election Deleted");
	}

	public List<Admin> viewElection() {
		logger.info("View Election");
		String sql = "select election_id,election_type,election_date from Election";
		List<Admin> electionList = jdbctemplate.query(sql, new ElectionMapper());
		logger.info(electionList + "election records");
		return electionList;
	}

	// Feedback list
	public List<Voter> viewFeedback() {
		logger.info("View Feedback");
		String sql = "select user_id,feedback from Feedback";
		List<Voter> feedbackList = jdbctemplate.query(sql, new FeedbackMapper());
		logger.info(feedbackList + "feedback records");
		return feedbackList;
	}

	// Voter's Report
	public List<Voter> viewReports() {
		logger.info("View Reports");
		String sql = "select user_id,party_name,complaints from usercomplaints";
		List<Voter> reportList = jdbctemplate.query(sql, new ReportMapper());
		logger.info(reportList + "reports records");
		return reportList;
	}

	// Maximum Vote count
	public List<VoteCount> viewResult() {
		String sql = "select distinct party_name,count from VoteCount where count=(select Max(count) from voteCount)";
		List<VoteCount> countList = jdbctemplate.query(sql, new VoteCountMapper());
		logger.info(countList + "result records");
		return countList;
	}

	public Integer voteCount(Model model) {
		String query="select distinct party_name from Candidate";
		List<Candidate> partyName= jdbctemplate.query(query,new PartyNameMapper());
		model.addAttribute("PARTYNAME", partyName);
		logger.info(partyName + "count records");
		
		Integer count=0;
		String name = null;
		
		for (Candidate candidate : partyName) {
			 name=candidate.getCanPartyName();
		
		String query1 = "select count(party_name) from CastingVote where party_name=?";
		 count= jdbctemplate.queryForObject(query1, Integer.class,name);
		 
		String insert="insert into voteCount(party_name,count) values (?,?)";
		Object[] ins= {name,count};
		jdbctemplate.update(insert, ins);
		logger.info("Count Inserted ");
		}
		return count;
	}
	
	//separate vote count
	public List<VoteCount> separateVoteCount(Model model) {
		String query1="select DISTINCT (party_name),count from voteCount";
		List<VoteCount> countList=jdbctemplate.query(query1,new VoteCountMapper());
		model.addAttribute("COUNTLIST", countList);
		return countList;
		
	}


	// Total vote count
	public Integer totalVoteCount() {
		String sql = "SELECT COUNT(*) FROM CastingVote";
		return jdbctemplate.queryForObject(sql, Integer.class);

	}

	//Total user count
	public Integer totalUserCount() {
		String sql = "SELECT COUNT(*) FROM ResidVoter";
		return jdbctemplate.queryForObject(sql, Integer.class);
	}

	//Total NRI user count
	public Integer totalNRIuserCount() {
		String sql = "SELECT COUNT(*) FROM NRIVoter";
		return jdbctemplate.queryForObject(sql, Integer.class);
	}
	
	//total candidate count
	public Integer totalCandidateCount() {
		String sql = "SELECT COUNT(*) FROM Candidate";
		return jdbctemplate.queryForObject(sql, Integer.class);
	}
	

	// Expense calculation
	public void expenseCalculate(Admin admin) {
		int assetValue = admin.getAssetValue();
		int pAssetValue = admin.getPastAssetValue();
		if (assetValue <= pAssetValue) {
			logger.info("Eligible for the election");
			String query = "insert into adminReport(candidate_name,party_name,report_about_candidate) values(?,?,?)";
			Object[] reg = { admin.getCandidateName(),admin.getPartyName(), admin.getReportOfCandidate() };
			jdbctemplate.update(query, reg);
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

		if(pDuration >4 && rYear<5) {
			logger.info("You Can't Apply for Election For 5 Years");
			return false;
		}
		else {
				logger.info("You Can Apply for Election");
				return true;
				}
	}
	
	public Float votePercentageCalculation() {
		Integer totalCount=totalVoteCount();
		
		Integer userCount=totalUserCount();
		
		return (totalCount.floatValue()/userCount.floatValue())*100;
	}
	
	public float voteNRIPercentageCalculation() {
		Integer totalCount=totalVoteCount();
		
		Integer userCount=totalNRIuserCount();
		
		return (totalCount.floatValue()/userCount.floatValue())*100;
	}
	
	public List<Voter> search(String searchData) {
		String query="select ResidVoter.voter_name,ResidVoter.date_of_birth,ResidVoter.age,ResidVoter.voter_id,ResidVoter.father_name,ResidVoter.gender,ResidVoter.address,ResidVoter.city,ResidVoter.nationality,ResidVoter.mobileNumber,ResidVoter.email_id,castingVote.party_name,castingVote.vote from ResidVoter inner join castingVote on ResidVoter.voter_id=castingVote.voter_id where ResidVoter.gender like ? or ResidVoter.voter_id like ? or ResidVoter.city like ?";
		return jdbctemplate.query(query,new SearchListMapper(),searchData,searchData,searchData);
	}
	
	public List<NRIVoter> searchNRI(String searchNRIData) {
		String query="select nrivoter.voter_name,nrivoter.date_of_birth,nrivoter.age,nrivoter.voter_id,nrivoter.father_name,nrivoter.gender,nrivoter.nationality,nrivoter.state,nrivoter.city,nrivoter.email_id,castingVote.party_name,castingVote.vote from nrivoter inner join castingVote on nrivoter.voter_id=castingVote.voter_id where nrivoter.gender like ? or nrivoter.voter_id like ? nrivoter.city like ?";
		return jdbctemplate.query(query,new SearchListNRIMapper(),searchNRIData,searchNRIData,searchNRIData);
	}
}

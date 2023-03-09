package com.project.evotingsystemspring.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.evotingsystemspring.dao.AdminDAO;
import com.project.evotingsystemspring.model.Admin;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.VoteCount;
import com.project.evotingsystemspring.model.Voter;

@Service
public class AdminService {
	@Autowired
	AdminDAO adminDao;
	
	public Boolean adminLogin(Admin admin, HttpSession session, Model model) {
		return adminDao.adminLogin(admin, session, model);
	}
	
	public void viewVoterService(Model model) {
		List<Voter> voterList=adminDao.viewVoter();
		model.addAttribute("VOTER_LIST", voterList);
	}
	
	public void viewNRIvoterService(Model model) {
		List<NRIVoter> voterList=adminDao.viewNriVoter();
		model.addAttribute("NRIVOTER_LIST", voterList);
	}
	
	public void viewVotersVoteService(Model model) {
		List<CastingVote> voterList=adminDao.viewVoterVoteDetails();
		model.addAttribute("VOTERVOTE_LIST", voterList);
	}
	
	public void addCandidateService(Candidate candidate) {
		adminDao.addCandidates(candidate);
	}
	
	public void updateCandidateService(Candidate candidate) {
		adminDao.updateCandidates(candidate);
	}
	
	public void deleteCandidateService(Candidate candidate) {
		adminDao.deleteCandidates(candidate);
	}
	
	public void viewCanService(Model model) {
		List<Candidate> candidateList=adminDao.viewCandidates();
		model.addAttribute("CANDIDATE_LIST", candidateList);
	}
	
	public void reportOfCandidateService(Admin admin) {
		adminDao.expenseCalculate(admin);
	}
	
	public void addElectionService(Admin admin) {
		adminDao.addElection(admin);
	}
	
	public void deleteElectionService(Admin admin) {
		adminDao.deleteElection(admin);

	}
	
	public void viewElection(Model model) {
		List<Admin> eleList=adminDao.viewElection();
		model.addAttribute("ELECTION_LIST", eleList);
	}
	
	public void viewFeedbackService(Model model) {
		List<Voter> feedList=adminDao.viewFeedback();
		model.addAttribute("FEEDBACK_LIST", feedList);
	}
	
	public void viewReportService(Model model) {
		List<Voter> rList=adminDao.viewReports();
		model.addAttribute("REPORT_LIST", rList);
	}
	
	public void viewResultService(Model model) {
		List<VoteCount> countList=adminDao.viewResult();
		model.addAttribute("COUNT_LIST", countList);
	}
	
	public void voteCountService(Model model) {
		int pCount=adminDao.voteCount(model);
		 model.addAttribute("PARTYCOUNT", pCount);
	}
	
	public List<Voter> searchService(String searchData) {
		return adminDao.search(searchData);
	}
	
	public List<NRIVoter> searchNRIService(String searchNRIData) {
		return adminDao.searchNRI(searchNRIData);
	}
}

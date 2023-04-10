package com.project.evotingsystemspring.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.evotingsystemspring.dao.AdminDAO;
import com.project.evotingsystemspring.model.Admin;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.VoteCount;
import com.project.evotingsystemspring.model.Voter;

@Service
public class AdminService {
	
	AdminDAO adminDao=new AdminDAO();
	
	public Boolean adminLogin(Admin admin, HttpSession session, Model model) {
		return adminDao.adminLogin(admin, session, model);
	}
	
	public void viewVoterService(Model model)throws JsonProcessingException  {
		adminDao.viewVoter(model);
	
	}
	
	public void viewNRIvoterService(Model model)throws JsonProcessingException  {
		adminDao.viewNRIvoter(model);
	}
	
	public void viewVotersVoteService(Model model)throws JsonProcessingException {
		adminDao.viewVoterVoteDetails(model);
		
	}
	
	public void addCandidateService(Candidate candidate) {
		adminDao.addCandidates(candidate);
	}
	
	public void deleteCandidateService(Candidate candidate) {
		adminDao.deleteCandidates(candidate);
	}
	
	public void viewCanService(Model model) {
		List<Candidate> candidateList=adminDao.viewCandidates( );
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
	
	public void viewElection(Model model) throws JsonProcessingException{
		adminDao.viewElection(model);
		
	}
	
	public void viewFeedbackService(Model model) throws JsonProcessingException {
		adminDao.viewFeedback(model);
		
	}
	
	public void viewReportService(Model model) throws JsonProcessingException {
		List<Voter> rList=adminDao.viewReports(model);
		model.addAttribute("REPORT_LIST", rList);
	}
	
	public void viewResultService(Model model) {
		List<VoteCount> countList=adminDao.viewResult( model);
		model.addAttribute("COUNT_LIST", countList);
	}
	
	public void voteCountService(Model model) {
		int pCount=adminDao.voteCount(model);
		 model.addAttribute("PARTYCOUNT", pCount);
	}
	
	
}

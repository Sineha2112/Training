package com.project.evotingsystemspring.daointerface;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.evotingsystemspring.model.Admin;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.VoteCount;
import com.project.evotingsystemspring.model.Voter;

public interface AdminInterface {

	public Boolean adminLogin(Admin admin, HttpSession session, Model model);
	
	public void viewVoter(Model model) throws JsonProcessingException  ;
	public void viewNRIvoter(Model model) throws JsonProcessingException ;
	public void viewVoterVoteDetails(Model model)throws JsonProcessingException ;
	
	public void addCandidates(Candidate candidate);
	public void deleteCandidates(Candidate candidate) ;
	public List<Candidate> viewCandidates() ;
	
	public void addElection(Admin a);
	public void deleteElection(Admin a) ;
	public List<Admin> viewElection(Model model)throws JsonProcessingException;
	
	public void viewFeedback(Model model)throws JsonProcessingException ;
	public List<Voter> viewReports(Model model) throws JsonProcessingException ;
	public List<VoteCount> viewResult();
	
	public Integer voteCount(Model model);
	
	public Integer totalVoteCount();
	public Integer totalUserCount();
	public Integer totalNRIuserCount();
	
	public void expenseCalculate(Admin admin) ;
	public boolean criminalRecords(Candidate candidate) ;
	
}

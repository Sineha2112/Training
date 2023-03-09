package com.project.evotingsystemspring.daointerface;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.project.evotingsystemspring.model.Admin;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.VoteCount;
import com.project.evotingsystemspring.model.Voter;

public interface AdminInterface {

	public Boolean adminLogin(Admin admin, HttpSession session, Model model);
	
	public List<Voter> viewVoter() ;
	public List<NRIVoter> viewNriVoter() ;
	public List<CastingVote> viewVoterVoteDetails() ;
	
	public void addCandidates(Candidate c);
	public int updateCandidates(Candidate c);
	public void deleteCandidates(Candidate c) ;
	public List<Candidate> viewCandidates();
	
	public void addElection(Admin a);
	public void deleteElection(Admin a) ;
	public List<Admin> viewElection();
	
	public List<Voter> viewFeedback();
	public List<Voter> viewReports() ;
	public List<VoteCount> viewResult();
	
	public Integer voteCount(Model model);
	
	public Integer totalVoteCount();
	public Integer totalUserCount();
	public Integer totalNRIuserCount();
	
	public void expenseCalculate(Admin admin) ;
	public boolean criminalRecords(Candidate candidate) ;
}

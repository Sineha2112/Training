package com.project.evotingsystemspring.daointerface;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.myexception.AlreadyVotedException;
import com.project.evotingsystemspring.myexception.DuplicationOfMailException;
import com.project.evotingsystemspring.myexception.DuplicationOfMobileNoException;

public interface VoterInterface {
	
	public void nriVoterRegister(NRIVoter nVoter,HttpSession session);

	public Boolean emailExist(Voter voter,Model model) ;
	public Boolean mobileNoExist(Voter voter,Model model) ;
	public Boolean voterLogin(Voter voter,HttpSession session,Model model);
	public void forgetPassword(Voter voter);
	public void viewProfile(HttpSession session);
	public int updateProfile(Voter voter,HttpSession session) ;
	public void castVote(CastingVote castvote,HttpSession session);
	public Boolean userIdPerVote(CastingVote castVote,Model model)  ;
	public void addFeedback(Voter voter);
	public void addComplaints(Voter voter) ;
	public boolean gettingElectionDate(Model model);
}

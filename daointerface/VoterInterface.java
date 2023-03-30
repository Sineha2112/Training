package com.project.evotingsystemspring.daointerface;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.myexception.AlreadyVotedException;
import com.project.evotingsystemspring.myexception.DuplicationOfMailException;
import com.project.evotingsystemspring.myexception.DuplicationOfMobileNoException;
import com.project.evotingsystemspring.myexception.InvalidAgeException;
import com.project.evotingsystemspring.myexception.InvalidEmailIdException;

public interface VoterInterface {
	
	public void voterRegister(Voter voter,HttpSession session) throws InvalidAgeException, InvalidEmailIdException, DuplicationOfMailException;
	public void emailExist(Voter voter) throws DuplicationOfMailException ;
	public void mobileNoExist(Voter voter) throws DuplicationOfMobileNoException;
	public Boolean voterLogin(Voter voter,HttpSession session,Model model);
	public void forgetPassword(Voter voter);
	public void viewProfile(HttpSession session);
	public int updateProfile(Voter voter,HttpSession session) ;
	public void castVote(CastingVote castvote,HttpSession session);
	public void userIdPerVote(CastingVote castVote) throws AlreadyVotedException ;
	public void addFeedback(Voter voter);
	public void addComplaints(Voter voter) ;
	public boolean gettingElectionDate(Model model);
}

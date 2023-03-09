package com.project.evotingsystemspring.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.evotingsystemspring.dao.VoterDAO;
import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.myexception.AlreadyVotedException;

@Service
public class VoterService {
	@Autowired
	VoterDAO voterdao;
	
	public void voterRegisterService(Voter voter,HttpSession session) {
		voterdao.voterRegister(voter,session );
	}
	
	public Boolean voterLoginService(Voter voter,HttpSession session,Model model) {
		return voterdao.voterLogin(voter, session, model);
	}
	
	public void updatePasswordService(Voter voter) {
		voterdao.forgetPassword(voter);
	}
	
	public void castVoteService(CastingVote castVote,HttpSession session) throws AlreadyVotedException {
		voterdao.userIdPerVote(castVote);
		voterdao.castVote(castVote,session);
	}
	
	public void feedbackService(Voter voter){
		voterdao.addFeedback(voter);
	}
	
	public void complaintService(Voter voter) {
		voterdao.addComplaints(voter);
	}
	
	public void viewService(HttpSession session) {
		voterdao.viewProfile(session);
	}
	
	public void updateService(Voter voter,HttpSession session) {
		voterdao.updateProfile(voter,session);
	}
}

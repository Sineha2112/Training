package com.project.evotingsystemspring.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.evotingsystemspring.dao.NRIvoterDAO;
import com.project.evotingsystemspring.dao.VoterDAO;
import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.myexception.AlreadyVotedException;

@Service
public class VoterService {
	
	VoterDAO voterDao=new VoterDAO();
	
	NRIvoterDAO nVoterDao=new NRIvoterDAO();
	
	public void voterRegisterService(Voter voter,HttpSession session) {
		nVoterDao.voterRegister(voter,session );
	}
	
	public Boolean voterLoginService(Voter voter,HttpSession session,Model model) {
		return voterDao.voterLogin(voter, session, model);
	}
	
	public void updatePasswordService(Voter voter) {
		voterDao.forgetPassword(voter);
	}
	
	public void castVoteService(CastingVote castVote,HttpSession session) {
		voterDao.castVote(castVote,session);
	}
	
	public void feedbackService(Voter voter){
		voterDao.addFeedback(voter);
	}
	
	public void complaintService(Voter voter) {
		voterDao.addComplaints(voter);
	}
	
	public void viewService(HttpSession session) {
		voterDao.viewProfile(session);
	}
	
	public void updateService(Voter voter,HttpSession session) {
		voterDao.updateProfile(voter,session);
	}
}

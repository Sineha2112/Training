package com.project.evotingsystemspring.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.evotingsystemspring.dao.NRIvoterDAO;
import com.project.evotingsystemspring.dao.VoterDAO;
import com.project.evotingsystemspring.model.NRIVoter;

@Service
public class NRIVoterService {
	
	NRIvoterDAO nVoterDao=new NRIvoterDAO();
	
	VoterDAO voterDao=new VoterDAO();
	
	public void voterNRIregister(NRIVoter nvoter,HttpSession session) {
		voterDao.nriVoterRegister(nvoter,session);
	}
	
	public Boolean voterNRIlogin(NRIVoter nvoter,HttpSession session,Model model) {
		return nVoterDao.voterLogin(nvoter,session,model);
	}
	
	public void updatePasswordService(NRIVoter nvoter) {
		nVoterDao.forgetPassword(nvoter);
	}
	
	public void viewService(HttpSession session) {
		nVoterDao.viewNRIprofile(session);
	}
	
	public void updateService(NRIVoter nvoter,HttpSession session) {
		nVoterDao.updateProfile(nvoter, session);
	}
	
	
	
	
}

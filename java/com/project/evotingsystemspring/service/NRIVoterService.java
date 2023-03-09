package com.project.evotingsystemspring.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.evotingsystemspring.dao.NRIvoterDAO;
import com.project.evotingsystemspring.model.NRIVoter;

@Service
public class NRIVoterService {
	@Autowired
	NRIvoterDAO nvoterdao;
	
	public void voterNRIregister(NRIVoter nvoter,HttpSession session) {
		nvoterdao.nriVoterRegister(nvoter,session);
	}
	
	public Boolean voterNRIlogin(NRIVoter nvoter,HttpSession session,Model model) {
		return nvoterdao.voterLogin(nvoter,session,model);
	}
	
	public void updatePasswordService(NRIVoter nvoter) {
		nvoterdao.forgetPassword(nvoter);
	}
	
	public void viewService(HttpSession session) {
		nvoterdao.viewNRIprofile(session);
	}
	
	public void updateService(NRIVoter nvoter,HttpSession session) {
		nvoterdao.updateProfile(nvoter, session);
	}
}

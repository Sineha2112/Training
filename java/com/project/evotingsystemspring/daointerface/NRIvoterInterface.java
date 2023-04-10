package com.project.evotingsystemspring.daointerface;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.Voter;

public interface NRIvoterInterface {
	

	public void voterRegister(Voter voter,HttpSession session) ;
	
	public Boolean emailExist(NRIVoter nvoter,Model model) ;
	
	public Boolean voterLogin(NRIVoter nVoter, HttpSession session, Model model);
	public void viewNRIprofile( HttpSession session);
	public int updateProfile(NRIVoter nvoter,HttpSession session) ;
}

package com.project.evotingsystemspring.daointerface;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.myexception.DuplicationOfMailException;
import com.project.evotingsystemspring.myexception.InvalidAgeException;

public interface NRIvoterInterface {
	
	public void nriVoterRegister(NRIVoter nvoter,HttpSession session) throws InvalidAgeException;
	public void emailExist(NRIVoter nvoter) throws DuplicationOfMailException;
	
	public Boolean voterLogin(NRIVoter nVoter, HttpSession session, Model model);
	public void viewNRIprofile( HttpSession session);
	public int updateProfile(NRIVoter nvoter,HttpSession session) ;
}

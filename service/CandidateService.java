package com.project.evotingsystemspring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.evotingsystemspring.dao.AdminDAO;
import com.project.evotingsystemspring.dao.CandidateDAO;
import com.project.evotingsystemspring.model.Candidate;

@Service
public class CandidateService {

	CandidateDAO candidateDao=new CandidateDAO();
	AdminDAO adminDao=new AdminDAO();
	
	public void registerCandidateService(Candidate candidate) {
		adminDao.criminalRecords(candidate);
		candidateDao.regCandidate(candidate);
	}
	
	public void viewCandService(Model model) {
		List<Candidate> candidateList=candidateDao.viewRegCandidates();
		model.addAttribute("CANDIDATE_LIST", candidateList);
	}
}

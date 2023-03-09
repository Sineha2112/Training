package com.project.evotingsystemspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.evotingsystemspring.dao.CandidateDAO;
import com.project.evotingsystemspring.model.Candidate;

@Service
public class CandidateService {
	@Autowired
	CandidateDAO candidatedao;
	
	public void registerCandidateService(Candidate candidate) {
		 candidatedao.regCandidate(candidate);
	}
	
	public void viewCandService(Model model) {
		List<Candidate> candidateList=candidatedao.viewRegCandidates();
		model.addAttribute("CANDIDATE_LIST", candidateList);
	}
}

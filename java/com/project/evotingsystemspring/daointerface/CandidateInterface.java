package com.project.evotingsystemspring.daointerface;

import java.util.List;

import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.evotingsystemspring.model.Candidate;

public interface CandidateInterface {
	
	public void regCandidate(Candidate candidate) ;
	public List<Candidate> viewRegCandidates(Model model) throws JsonProcessingException;
}

package com.project.evotingsystemspring.daointerface;

import java.util.List;

import com.project.evotingsystemspring.model.Candidate;

public interface CandidateInterface {
	
	public void regCandidate(Candidate candidate) ;
	public List<Candidate> viewRegCandidates();
}

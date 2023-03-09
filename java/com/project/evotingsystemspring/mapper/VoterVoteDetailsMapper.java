package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.CastingVote;

public class VoterVoteDetailsMapper implements RowMapper<CastingVote> {

	@Override
	public CastingVote mapRow(ResultSet rs, int rowNum) throws SQLException {
		CastingVote castvote=new CastingVote();
		
		String eType=rs.getString("election_type");
		String vId=rs.getString("voter_id");
		String pName=rs.getString("party_name");
		String vote=rs.getString("vote");
		
		castvote.setElectionType(eType);
		castvote.setVoterId(vId);
		castvote.setPartyName(pName);
		castvote.setVote(vote);
		
		return castvote;
	}

}

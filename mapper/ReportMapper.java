package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Admin;
import com.project.evotingsystemspring.model.Voter;

public class ReportMapper implements RowMapper<Voter> {

	@Override
	public Voter mapRow(ResultSet rs, int rowNum) throws SQLException {
		Voter voter=new Voter();
		int uId=rs.getInt("user_id");
		String pName=rs.getString("party_name");
		String report=rs.getString("complaints");
		
		voter.setUserId(uId);
		voter.setPartyName(pName);
		voter.setComplaints(report);
		
		return voter;
	}

}

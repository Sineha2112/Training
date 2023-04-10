package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Voter;

public class FeedbackMapper implements RowMapper<Voter>{

	@Override
	public Voter mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Voter voter=new Voter();
		Integer uId=rs.getInt("user_id");
		String feedback=rs.getString("feedback");
		Integer rating=rs.getInt("rating");
		
		voter.setUserId(uId);
		voter.setFeedback(feedback);
		voter.setRate(rating);
		
		return voter;
	}
	

}

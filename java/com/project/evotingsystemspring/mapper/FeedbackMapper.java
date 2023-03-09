package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Voter;

public class FeedbackMapper implements RowMapper<Voter>{

	@Override
	public Voter mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Voter v=new Voter();
		int uId=rs.getInt("user_id");
		String feedback=rs.getString("feedback");
		
		v.setUserId(uId);
		v.setFeedback(feedback);
		
		return v;
	}
	

}

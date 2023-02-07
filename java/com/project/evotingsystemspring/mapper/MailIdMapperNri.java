package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.NriVoter;
import com.project.evotingsystemspring.model.Voter;

public class MailIdMapperNri implements RowMapper<NriVoter>{

	@Override
	public NriVoter mapRow(ResultSet rs, int rowNum) throws SQLException {
		NriVoter nvoter=new NriVoter();
		String email=rs.getString("email_id");
		nvoter.setEmailId(email);
		return nvoter;
	}

}

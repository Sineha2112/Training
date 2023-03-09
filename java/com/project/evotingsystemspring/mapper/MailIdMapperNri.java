package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.Voter;

public class MailIdMapperNri implements RowMapper<NRIVoter>{

	@Override
	public NRIVoter mapRow(ResultSet rs, int rowNum) throws SQLException {
		NRIVoter nvoter=new NRIVoter();
		String email=rs.getString("email_id");
		nvoter.setNriEmailId(email);
		return nvoter;
	}

}

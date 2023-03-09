package com.project.evotingsystemspring.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Admin;

public class ElectionMapper implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin=new Admin();
		Integer eId=rs.getInt("election_id");
		String eType=rs.getString("election_type");
		Date edate=rs.getDate("election_date");
		
		admin.setElectionId(eId);
		admin.setElectionName(eType);
		admin.setElectionDate(edate);
		
		return admin;
	}

}

package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Admin;

public class AdminMapper implements RowMapper<Admin>{

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin=new Admin();
		String aId=rs.getString("admin_id");
		String aName=rs.getString("admin_name");
		String aPassword=rs.getString("admin_password");
		
		admin.setAdminId(aId);
		admin.setAdminName(aName);
		admin.setPassword(aPassword);
		return admin;
	}

}

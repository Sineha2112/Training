package com.project.evotingsystemspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.springframework.jdbc.core.RowMapper;

import com.project.evotingsystemspring.model.Candidate;

public class CandidateMapper implements RowMapper<Candidate> {

	@Override
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidate c=new Candidate();
		
		byte[] canImg=rs.getBytes(1);
		byte[] syImg=rs.getBytes(2);
		int eId=rs.getInt(3);
		int cId=rs.getInt(4);
		String pName=rs.getString(5);
		String pSymbol=rs.getString(6);
		String cName=rs.getString(7);
		String gender=rs.getString(8);
		int age=rs.getInt(9);
		String address=rs.getString(10);
		String city=rs.getString(11);
		String nationality=rs.getString(12);
		Long mNo=rs.getLong(13);
		String email=rs.getString(14);
		String history=rs.getString(15);
		
		String base64Image = Base64.getEncoder().encodeToString(canImg);
		String base64Image1 = Base64.getEncoder().encodeToString(syImg);
		
		c.setCandidateImage(canImg);
		c.setSymbolImage(syImg);
		c.setImgPath(base64Image);
		c.setImgPath1(base64Image1);
		c.setElectionId(eId);
		c.setCandidateId(cId);
		c.setCanPartyName(pName);
		c.setCanPartySymbol(pSymbol);
		c.setCandidateName(cName);
		c.setCanGender(gender);
		c.setCanAge(age);
		c.setCanAddress(address);
		c.setCanCity(city);
		c.setCanNationality(nationality);
		c.setCanMobileNo(mNo);
		c.setCanEmailId(email);
		c.setHistory(history);
		
		return c;
	}

}

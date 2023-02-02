package com.project.evotingsystemspring.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.evotingsystemspring.mapper.MailIdMapper;
import com.project.evotingsystemspring.mapper.MobileNoMapper;
import com.project.evotingsystemspring.mapper.VoterMapper;
import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.myexception.DuplicationOfMailException;
import com.project.evotingsystemspring.myexception.DuplicationOfMobileNoException;

@Repository
public class VoterDAO {
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	Logger logger = LoggerFactory.getLogger(VoterDAO.class);
	
	public void voterRegister(Voter voter) {
		logger.info("To Register User");
		String query="insert into ResVoter(user_id,voter_name,date_of_birth,age,voter_id,father_name,gender,address,city,nationality,mobileNumber,email_id,voter_password) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object reg[]= {voter.getUserId(),voter.getVoterName(),voter.getDateOfBirth(),voter.getAge(),voter.getVoterId(),voter.getFatherName(),voter.getGender(),voter.getAddress(),voter.getCity(),voter.getNationality(),voter.getMobileNumber(),voter.getEmailId(),voter.getUserPassword()};
		int rows=jdbctemplate.update(query, reg);
		System.out.println("Row Inserted:"+rows);
	}
	
	//existing emailId
	public void emailExist(Voter voter) throws DuplicationOfMailException {
		String email=voter.getEmailId();
		String query="select email_id from ResVoter";
		List<Voter> voterList=jdbctemplate.query(query, new MailIdMapper());
		 for (Voter voterli : voterList) {
	            String mailId=voterli.getEmailId();
	            if(mailId.equals(email)) {
	              throw new DuplicationOfMailException();
	                
	            }
	            else
	                 logger.info("Continue");
	        }
	}
	
	//existing mobileNo
	public void mobileNoExist(Voter voter) throws DuplicationOfMobileNoException {
		Long mobileNo=voter.getMobileNumber();
		System.out.println(mobileNo);
		String query="select mobileNumber from ResVoter where mobileNumber=?";
		List<Voter> voterList=jdbctemplate.query(query, new MobileNoMapper(),mobileNo);
		 for (Voter voterli : voterList) {
	            Long mNo=voterli.getMobileNumber();
	            if(mNo.equals(mobileNo)) {
	              throw new DuplicationOfMobileNoException();
	                
	            }
	            else
	                 logger.info("Continue");
		 } 
	}
	
	public int generateRandomId() {
		int randomId=(int)((float)Math.random()*1000);
		return randomId;
	}
	
	public void voterLogin(Voter voter) {
		logger.info("To Login User");
		String query="select voter_id,voter_password from ResVoter where voter_id=?";
		List<Voter> userList = (List<Voter>) jdbctemplate.queryForObject(query, new VoterMapper());
		
		
	}
	
	public List<Voter> viewProfile(Integer id){ 
		String sql = "select * from ResVoter where voter_id=?";
		List<Voter> userList = (List<Voter>) jdbctemplate.queryForObject(sql, new VoterMapper(),id);
		logger.info(userList+"Fetched records");
		return userList;
	}
	public void CastVote(CastingVote v) { 
		
	}

	public String findById(String name) {
	     String sql = "select user_id from ResVoter  where voter_name=?";
         System.out.println("DB Status");
         String queryForObject = null;
         try {
             queryForObject = jdbctemplate.queryForObject(sql, String.class,name);
             System.out.println(queryForObject);
         } catch (EmptyResultDataAccessException e) {
         }
         return queryForObject;
		
	}
}

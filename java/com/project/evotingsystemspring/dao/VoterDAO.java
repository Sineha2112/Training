package com.project.evotingsystemspring.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.project.evotingsystemspring.mapper.LoginVoterMapper;
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
		String query="insert into ResidVoter(user_id,voter_name,date_of_birth,age,voter_id,father_name,gender,address,city,nationality,mobileNumber,email_id,voter_password) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
		
		String query="select mobileNumber from ResidVoter where mobileNumber=?";
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
	
	public void voterLogin(Voter voter,HttpSession session,Model model) {
		logger.info("To login");
		String status;
		String vId=voter.getVoterId();
		String pass=voter.getUserPassword();
		try {
		String query="select voter_name,voter_id,voter_password from ResidVoter where voter_id=?";
		List<Voter> userList = (List<Voter>) jdbctemplate.query(query, new LoginVoterMapper(),vId);
		 for (Voter voterli : userList) {
			 if(voterli!=null) {
				 String voterId=voterli.getVoterId();
				 if(voterId.equals(vId)) {
					 String password=voterli.getUserPassword();
					 if(pass.equals(password)) {
						 status="Success";
						 String name=voterli.getVoterName();
						 session.setAttribute("VoterId", voterId);
						 session.setAttribute("userName", name);
						 model.addAttribute("loginstatus", status);
					 }
						return ;
					 }
				 else {
					 status="InvalidCredentials";
					 model.addAttribute("loginstatus", status);
					 return ;
					
					 }
			 }
			 status="InvalidCredentials";
			 model.addAttribute("loginstatus", status);
						
				 }
		}catch(NullPointerException e) {
			System.out.println(e);
		}
			
	}

	
	public List<Voter> viewProfile(HttpSession session){ 
		String voterid=(String) session.getAttribute("VoterId");
		String sql = "select user_id,voter_name,date_of_birth,age,voter_id,father_name,gender,address,city,nationality,mobileNumber,email_id,voter_password from ResidVoter where voter_id=?";
		List<Voter> userList = (List<Voter>) jdbctemplate.query(sql, new VoterMapper(),voterid);
		for(Voter v:userList ) {
			Integer id=v.getUserId();
			session.setAttribute("Id", id);
		}
		logger.info(userList+"Fetched records");
		return userList;
	}
	
	public void CastVote(CastingVote castvote) { 
		logger.info("To Cast Vote");
		String query="insert into CastingVote(election_type,user_id,party_name,vote) values (?,?,?,?)";
		Object vote[]= {castvote.getElectionType(),castvote.getUserId(),castvote.getPartyName(),castvote.getVote()};
		int rows=jdbctemplate.update(query, vote);
		logger.info("Voted:"+rows);
		
	}

	public String findById(String name) {
	     String sql = "select user_id from ResidVoter  where voter_name=?";
         System.out.println("DB Status");
         String queryForObject = null;
         try {
             queryForObject = jdbctemplate.queryForObject(sql, String.class,name);
             System.out.println(queryForObject);
         } catch (EmptyResultDataAccessException e) {
         }
         return queryForObject;
		
	}
	
	public void addFeedback(Voter voter) {
		logger.info("To Add Feedback");
		String query="insert into Feedback(user_id,feedback) values(?,?)";
		Object reg[]= {voter.getUserId(),voter.getFeedback()};
		int rows=jdbctemplate.update(query, reg);
		System.out.println("Feedback Inserted:"+rows);
	}
	
	public void addComplaints(Voter voter) {
		logger.info("To Add Complaints");
		String query="insert into userComplaints(user_id,party_name,complaints) values(?,?,?)";
		Object reg[]= {voter.getUserId(),voter.getPartyName(),voter.getComplaints()};
		int rows=jdbctemplate.update(query, reg);
		System.out.println("Feedback Inserted:"+rows);
	}
}

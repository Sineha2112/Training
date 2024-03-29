package com.project.evotingsystemspring.dao;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.project.evotingsystemspring.connection.ConnectionUtil;
import com.project.evotingsystemspring.daointerface.NRIvoterInterface;
import com.project.evotingsystemspring.mapper.LoginMapperNri;
import com.project.evotingsystemspring.mapper.MailIdMapperNri;
import com.project.evotingsystemspring.mapper.NRIvoterMapper;
import com.project.evotingsystemspring.mapper.RandomIdMapper;
import com.project.evotingsystemspring.mapper.VoterIdNRIMapper;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.validation.ValidationVs;


public class NRIvoterDAO implements NRIvoterInterface{
	
	JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	VoterDAO voterDao=new VoterDAO();
	
	Logger logger = LoggerFactory.getLogger(NRIvoterDAO.class);
	
	ValidationVs validation=new ValidationVs();
	
	//resident voter registration
	public void voterRegister(Voter voter, HttpSession session) {
		logger.info("To Register User");


		Date dob = voter.getDateOfBirth();
		Integer age = validation.ageCalculator(dob);
		voter.setAge(age);

		String query = "insert into ResidentVoter(user_id,voter_name,date_of_birth,age,voter_id,father_name,gender,address,city,nationality,mobileNumber,email_id,voter_password) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] reg = { voter.getUserId(), voter.getVoterName(), voter.getDateOfBirth(), voter.getAge(),
				voter.getVoterId(), voter.getFatherName(), voter.getGender(), voter.getAddress(), voter.getCity(),
				voter.getNationality(), voter.getMobileNumber(), voter.getEmailId(), voter.getUserPassword() };
		jdbcTemplate.update(query, reg);

		String sql = "select user_id,voter_name,voter_id from ResidentVoter where voter_id=? ";
		List<Voter> voterList = jdbcTemplate.query(sql, new RandomIdMapper(), voter.getVoterId());
		for (Voter voter2 : voterList) {
			session.setAttribute("RANDOM_ID", voter2.getUserId());
			session.setAttribute("VoterId", voter2.getVoterId());
			session.setAttribute("userName", voter2.getVoterName());
		}

		logger.info("Row Inserted");
	}
	
	
	
	//existing emailId
	public Boolean emailExist(NRIVoter nVoter, Model model)  {
		String email=nVoter.getNriEmailId();
		String query="select email_id from NonResidentVoter";
		List<NRIVoter> voterList=jdbcTemplate.query(query, new MailIdMapperNri());
		 for (NRIVoter voterli : voterList) {
	            String mailId=voterli.getNriEmailId();
	            if(mailId.equals(email)) {
	            	String errorMessage = "Email Id Already exist ";
					model.addAttribute("errorMessage19", errorMessage);
					return false;
	                
	            }
	            else
	                 logger.info("Continue");
	        }
		return true;
	}
	
	//existing voterId
		public Boolean voterIdExist(NRIVoter nVoter, Model model)  {
			String voterId=nVoter.getNriVoterId();
			String query="select voter_id from NonResidentVoter";
			List<NRIVoter> voterList=jdbcTemplate.query(query, new VoterIdNRIMapper());
			 for (NRIVoter voterli : voterList) {
		            String vId=voterli.getNriVoterId();
		            if(vId.equals(voterId)) {
		            	String errorMessage = "Voter Id Already exist ";
						model.addAttribute("errorMessage20", errorMessage);
						return false;
		                
		            }
		            else
		                 logger.info("Continue");
		        }
			return true;
		}
	
	
	
	public Boolean voterLogin(NRIVoter nVoter, HttpSession session, Model model) {
		logger.info("To Login NRI User");
		String status;
		String vId = nVoter.getNriVoterId();
		String pass = nVoter.getnUserPassword();

		
			String query = "select voter_name,voter_id,voter_password from NonResidentVoter where voter_id=?";
			List<NRIVoter> userList = jdbcTemplate.query(query, new LoginMapperNri(), vId);
			for (NRIVoter voterli : userList) {
				if (voterli != null) {
					String voterId = voterli.getNriVoterId();
					if (voterId.equals(vId)) {
						String password = voterli.getnUserPassword();
						if (pass.equals(password)) {
							status = "Success";
							String name = voterli.getNriVoterName();
							session.setAttribute("nVoterId", voterId);
							session.setAttribute("nuserName", name);
							model.addAttribute("nLoginstatus", status);
							return true;
						}
						
					} else {
						status = "InvalidCredentials";
						model.addAttribute("nInvalidLoginStatus", status);
						return false;
					}
				}
			}
			return false;
	}
	
	//forget password
		public void forgetPassword(NRIVoter nVoter) {
			logger.info("Update NRI User password");
			
			String p1=nVoter.getnUserPassword();
			String p2=nVoter.getNriNewPassword();
			if(p1.equals(p2)) {
				String query="update NonResidentVoter set voter_password=? where email_id=?";
				Object[] upd= {p1,nVoter.getNriEmailId()};
				jdbcTemplate.update(query, upd);
				logger.info("Row Updated");
			}
			else {
				logger.info("Password doesn't match");
			}
		}
	
	public void viewNRIprofile( HttpSession session){ 
		String voterId=(String) session.getAttribute("nVoterId");
		logger.info(voterId);
		String sql = "select nri_id,voter_name,date_of_birth,age,voter_id,father_name,gender,nationality,address,city,email_id from NonResidentVoter where voter_id=?";
		List<NRIVoter> userList =  jdbcTemplate.query(sql, new NRIvoterMapper(),voterId);
		
		for (NRIVoter n : userList) {
			
			Integer nId=n.getNriId();
			session.setAttribute("NRIid", nId);
			
			String name=n.getNriVoterName();
			session.setAttribute("VoterName", name);
			
			Date dob=n.getNriDateOfBirth();
			session.setAttribute("DOB", dob);
			
			Integer age=n.getNriAge();
			session.setAttribute("Age", age);
			
			String vId=n.getNriVoterId();
			session.setAttribute("VoterId", vId);
			
			String fatherName=n.getNriFatherName();
			session.setAttribute("fatherName", fatherName);
			
			String gender=n.getNriGender();
			session.setAttribute("gender", gender);
			
			String nationality=n.getNriNationality();
			session.setAttribute("nationality", nationality);
			
			String address=n.getNriAddress();
			session.setAttribute("Address", address);
			
			String city=n.getNriCity();
			session.setAttribute("city", city);
			
			String email=n.getNriEmailId();
			session.setAttribute("emailId", email);
			
		}
		logger.info(userList+"voter NRI profile records");
	}
	
	//edit user profile
		public int updateProfile(NRIVoter nVoter,HttpSession session) {
			logger.info("Update NRI User Profile");
			Integer id=(Integer) session.getAttribute("id");
			
			String query="update NonResidentVoter set email_id=? where nri_id=?";
			Object[] upd= {nVoter.getNriEmailId(),id};
			int rows=jdbcTemplate.update(query, upd);
			logger.info("Row Updated");
			return rows;
		}
		

}

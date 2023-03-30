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
import com.project.evotingsystemspring.mapper.RandomIdNRIMapper;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.myexception.DuplicationOfMailException;
import com.project.evotingsystemspring.myexception.InvalidAgeException;
import com.project.evotingsystemspring.validation.ValidationVs;


public class NRIvoterDAO implements NRIvoterInterface{
	
	JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	VoterDAO voterDao=new VoterDAO();
	
	Logger logger = LoggerFactory.getLogger(NRIvoterDAO.class);
	
	ValidationVs validation=new ValidationVs();
	
	public void nriVoterRegister(NRIVoter nVoter,HttpSession session) throws InvalidAgeException {
		logger.info("To Register NRI User");
		
		Date dob=nVoter.getNriDateOfBirth();
		Integer age=validation.ageValidation(dob);
		nVoter.setNriAge(age);
		String query="insert into NonResidentVoter(nri_id,voter_name,date_of_birth,age,voter_id,father_name,gender,nationality,address,city,email_id,voter_password) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] reg= {nVoter.getNriId(),nVoter.getNriVoterName(),nVoter.getNriDateOfBirth(),nVoter.getNriAge(),nVoter.getNriVoterId(),nVoter.getNriFatherName(),nVoter.getNriGender(),nVoter.getNriNationality(),nVoter.getNriAddress(),nVoter.getNriCity(),nVoter.getNriEmailId(),nVoter.getnUserPassword()};
		jdbcTemplate.update(query, reg);
		
		String sql="select nri_id,voter_name,voter_id from NonResidentVoter where voter_id=? ";
		List<NRIVoter> voterList=jdbcTemplate.query(sql, new RandomIdNRIMapper(),nVoter.getNriVoterId());
		for (NRIVoter voter2 : voterList) {
			session.setAttribute("RANDOM_ID", voter2.getNriId());
			session.setAttribute("nVoterId", voter2.getNriVoterId());
			session.setAttribute("nuserName", voter2.getNriVoterName());
		}
		logger.info("Rows Inserted");
	}
	
	//existing emailId
	public void emailExist(NRIVoter nVoter) throws DuplicationOfMailException {
		String email=nVoter.getNriEmailId();
		String query="select email_id from NonResidentVoter";
		List<NRIVoter> voterList=jdbcTemplate.query(query, new MailIdMapperNri());
		 for (NRIVoter voterli : voterList) {
	            String mailId=voterli.getNriEmailId();
	            if(mailId.equals(email)) {
	              throw new DuplicationOfMailException();
	                
	            }
	            else
	                 logger.info("Continue");
	        }
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
			
			String nationality=n.getNriCity();
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

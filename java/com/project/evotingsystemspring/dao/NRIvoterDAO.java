package com.project.evotingsystemspring.dao;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.project.evotingsystemspring.daointerface.NRIvoterInterface;
import com.project.evotingsystemspring.mapper.LoginMapperNri;
import com.project.evotingsystemspring.mapper.MailIdMapperNri;
import com.project.evotingsystemspring.mapper.NriVoterMapper;
import com.project.evotingsystemspring.mapper.RandomIdMapper;
import com.project.evotingsystemspring.mapper.RandomIdNRIMapper;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.myexception.DuplicationOfMailException;

@Repository
public class NRIvoterDAO implements NRIvoterInterface{
	@Autowired
	JdbcTemplate jdbctemplate;
	
	Logger logger = LoggerFactory.getLogger(NRIvoterDAO.class);
	
	public void nriVoterRegister(NRIVoter nvoter,HttpSession session) {
		logger.info("To Register NRI User");
		String query="insert into NRIVoter(nri_id,voter_name,date_of_birth,age,voter_id,father_name,gender,nationality,state,city,email_id,voter_password) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] reg= {nvoter.getNriId(),nvoter.getNriVoterName(),nvoter.getNriDateOfBirth(),nvoter.getNriAge(),nvoter.getNriVoterId(),nvoter.getNriFatherName(),nvoter.getNriGender(),nvoter.getNriCity(),nvoter.getNriState(),nvoter.getNriCity(),nvoter.getNriEmailId(),nvoter.getnUserPassword()};
		jdbctemplate.update(query, reg);
		
		String sql="select nri_id,voter_name from NRIVoter where voter_id=? ";
		List<NRIVoter> voterList=jdbctemplate.query(sql, new RandomIdNRIMapper(),nvoter.getNriVoterId());
		for (NRIVoter voter2 : voterList) {
			session.setAttribute("RANDOM_ID", voter2.getNriId());
			session.setAttribute("nuserName", voter2.getNriVoterName());
		}
		logger.info("Rows Inserted");
	}
	
	//existing emailId
	public void emailExist(NRIVoter nvoter) throws DuplicationOfMailException {
		String email=nvoter.getNriEmailId();
		String query="select email_id from NRIVoter";
		List<NRIVoter> voterList=jdbctemplate.query(query, new MailIdMapperNri());
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

		
			String query = "select voter_name,voter_id,voter_password from NRIVoter where voter_id=?";
			List<NRIVoter> userList = jdbctemplate.query(query, new LoginMapperNri(), vId);
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
		public void forgetPassword(NRIVoter nvoter) {
			logger.info("Update NRI User password");
			
			String p1=nvoter.getnUserPassword();
			String p2=nvoter.getnUserPassword();
			if(p1.equals(p2)) {
				String query="update NRIVoter set voter_password=? where email_id=?";
				Object[] upd= {nvoter.getnUserPassword(),nvoter.getNriEmailId()};
				jdbctemplate.update(query, upd);
				logger.info("Row Updated");
			}
			else {
				logger.info("Password doesn't match");
			}
		}
	
	public void viewNRIprofile( HttpSession session){ 
		String voterId=(String) session.getAttribute("nVoterId");
		logger.info(voterId);
		String sql = "select nri_id,voter_name,date_of_birth,age,voter_id,father_name,gender,nationality,state,city,email_id from NRIVoter where voter_id=?";
		List<NRIVoter> userList =  jdbctemplate.query(sql, new NriVoterMapper(),voterId);
		
		for (NRIVoter n : userList) {
			
			Integer nId=n.getNriId();
			session.setAttribute("id", nId);
			
			String name=n.getNriVoterName();
			session.setAttribute("name", name);
			
			Date dob=n.getNriDateOfBirth();
			session.setAttribute("dob", dob);
			
			Integer age=n.getNriAge();
			session.setAttribute("age", age);
			
			String vId=n.getNriVoterId();
			session.setAttribute("voter", vId);
			
			String fatherName=n.getNriFatherName();
			session.setAttribute("fName", fatherName);
			
			String gender=n.getNriGender();
			session.setAttribute("gender", gender);
			
			String nationality=n.getNriCity();
			session.setAttribute("nationality", nationality);
			
			String state=n.getNriState();
			session.setAttribute("state", state);
			
			String city=n.getNriCity();
			session.setAttribute("city", city);
			
			String email=n.getNriEmailId();
			session.setAttribute("emailId", email);
			
		}
		logger.info(userList+"voter NRI profile records");
	}
	
	//edit user profile
		public int updateProfile(NRIVoter nvoter,HttpSession session) {
			logger.info("Update NRI User Profile");
			Integer id=(Integer) session.getAttribute("id");
			
			String query="update NRIVoter set voter_name=?,date_of_birth=?,voter_id=?,father_name=?,state=?,city=?,email_id=? where nri_id=?";
			Object[] upd= {nvoter.getNriVoterName(),nvoter.getNriDateOfBirth(),nvoter.getNriVoterId(),nvoter.getNriFatherName(),nvoter.getNriState(),nvoter.getNriCity(),nvoter.getNriEmailId(),id};
			int rows=jdbctemplate.update(query, upd);
			logger.info("Row Updated");
			return rows;
		}

}

package com.project.evotingsystemspring.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.project.evotingsystemspring.mapper.LoginMapperNri;
import com.project.evotingsystemspring.mapper.LoginVoterMapper;
import com.project.evotingsystemspring.mapper.MailIdMapper;
import com.project.evotingsystemspring.mapper.MailIdMapperNri;
import com.project.evotingsystemspring.mapper.NriVoterMapper;
import com.project.evotingsystemspring.model.NriVoter;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.myexception.DuplicationOfMailException;

@Repository
public class NriVoterDAO {
	@Autowired
	JdbcTemplate jdbctemplate;
	
	Logger logger = LoggerFactory.getLogger(NriVoterDAO.class);
	
	public void nriVoterRegister(NriVoter nvoter) {
		logger.info("To Register User");
		String query="insert into NRIVoter(user_id,voter_name,date_of_birth,age,voter_id,father_name,gender,nationality,state,city,email_id,voter_password) values(?,?,?,?,?,?,?,?,?,?,?)";
		Object reg[]= {nvoter.getNriId(),nvoter.getVoterName(),nvoter.getDateOfBirth(),nvoter.getAge(),nvoter.getVoterId(),nvoter.getFatherName(),nvoter.getGender(),nvoter.getNationality(),nvoter.getState(),nvoter.getCity(),nvoter.getEmailId(),nvoter.getUserPassword()};
		int rows=jdbctemplate.update(query, reg);
		logger.info("Rows Inserted:"+rows);
	}
	
	//existing emailId
	public void emailExist(NriVoter nvoter) throws DuplicationOfMailException {
		String email=nvoter.getEmailId();
		String query="select email_id from NRIVoter";
		List<NriVoter> voterList=jdbctemplate.query(query, new MailIdMapperNri());
		 for (NriVoter voterli : voterList) {
	            String mailId=voterli.getEmailId();
	            if(mailId.equals(email)) {
	              throw new DuplicationOfMailException();
	                
	            }
	            else
	                 logger.info("Continue");
	        }
	}
	
	public int generateRandomId() {
		int randomId=(int)((float)Math.random()*1000);
		return randomId;
	}
	
	public void voterLogin(NriVoter nVoter, HttpSession session, Model model) {
		logger.info("To Login User");
		String status;
		String vId = nVoter.getVoterId();
		String pass = nVoter.getUserPassword();

		try {
			String query = "select voter_id,voter_password from NRIVoter where voter_id=?";
			List<NriVoter> userList = (List<NriVoter>) jdbctemplate.query(query, new LoginMapperNri(), vId);
			for (NriVoter voterli : userList) {
				if (voterli != null) {
					String voterId = voterli.getVoterId();
					if (voterId.equals(vId)) {
						String password = voterli.getUserPassword();
						if (pass.equals(password)) {
							status = "Success";
							String name = voterli.getVoterName();
							session.setAttribute("userName", name);
							model.addAttribute("loginstatus", status);
						}
						return;
					} else {
						status = "InvalidCredentials";
						model.addAttribute("loginstatus", status);
						return;

					}

				}
				status = "InvalidCredentials";
				model.addAttribute("loginstatus", status);
			}
		} catch (NullPointerException e) {
			System.out.println(e);
		}
	}
	
	public List<NriVoter> viewNriProfile(Integer id){ 
		String sql = "select * from NRIVoter where voter_id=?";
		List<NriVoter> userList =  (List<NriVoter>) jdbctemplate.queryForObject(sql, new NriVoterMapper(),id);
		logger.info(userList+"Fetched records");
		return userList;
	}

}

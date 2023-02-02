package com.project.evotingsystemspring.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
	
	public void nriVoterRegister(NriVoter n) {
		System.out.println("To Register User");
		String query="insert into NRIVoter(user_id,voter_name,date_of_birth,age,voter_id,father_name,gender,nationality,state,city,email_id,voter_password) values(?,?,?,?,?,?,?,?,?,?,?)";
		Object reg[]= {n.getNriId(),n.getVoterName(),n.getDateOfBirth(),n.getAge(),n.getVoterId(),n.getFatherName(),n.getGender(),n.getNationality(),n.getState(),n.getCity(),n.getEmailId(),n.getUserPassword()};
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
	
	
	public List<NriVoter> viewNriProfile(Integer id){ 
		String sql = "select * from NRIVoter where voter_id=?";
		List<NriVoter> userList = (List<NriVoter>) jdbctemplate.queryForObject(sql, new NriVoterMapper(),id);
		logger.info(userList+"Fetched records");
		return userList;
	}

}

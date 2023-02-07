package com.project.evotingsystemspring.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import com.project.evotingsystemspring.mapper.AdminMapper;
import com.project.evotingsystemspring.mapper.CandidateMapper;
import com.project.evotingsystemspring.mapper.LoginVoterMapper;
import com.project.evotingsystemspring.mapper.NriVoterMapper;
import com.project.evotingsystemspring.mapper.VoteCountMapper;
import com.project.evotingsystemspring.mapper.VoterMapper;
import com.project.evotingsystemspring.model.Admin;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.model.NriVoter;
import com.project.evotingsystemspring.model.VoteCount;
import com.project.evotingsystemspring.model.Voter;

@Repository
@RestController
public class AdminDAO {
	@Autowired
	JdbcTemplate jdbctemplate;
	
	Logger logger = LoggerFactory.getLogger(AdminDAO.class);
	
	public void adminLogin(Admin admin,HttpSession session,Model model) {
		logger.info("To Login Admin");
		String status;
		String aId=admin.getAdminId();
		String pass=admin.getPassword();
		try {
			String query="select admin_name,admin_id,admin_password from Admin ";
			List<Admin> userList = (List<Admin>) jdbctemplate.query(query, new AdminMapper());
			 for (Admin adminli : userList) {
				 if(adminli!=null) {

					 if(aId.equals("admin")) {
						 if(pass.equals("admin123")) {
							 status="Success";
							 String name=adminli.getAdminName();
							 session.setAttribute("adminName", name);
							 model.addAttribute("loginstatus", status);
						 }
						 else 
							 logger.info("Invalid Password");
					 }
				 }
			 }
		}catch(NullPointerException e) {
			System.out.println(e);
		}
	}
	
	//Voter List
	public List<Voter> viewVoter(){
		String sql = "select * from Voter";
		List<Voter> voterList = (List<Voter>) jdbctemplate.query(sql, new VoterMapper());
		logger.info(voterList+"Fetched records");
		return voterList;
	}
	
	public List<NriVoter> viewNriVoter(){
		String sql = "select * from NRIVoter";
		List<NriVoter> voterList = (List<NriVoter>) jdbctemplate.query(sql, new NriVoterMapper());
		logger.info(voterList+"Fetched records");
		return voterList;
	}
	
	//Candidate
	public void addCandidates(Candidate c) {
		System.out.println("To Insert Candidates");
		String query="insert into Candidate(election_id,candidate_id,party_name,party_symbol,candidate_name,gender,age,address,city,nationality,mobileNo,emailId,history) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object insert[]= {c.getElectionId(),c.getCandidateId(),c.getPartyName(),c.getPartySymbol(),c.getCandidateName(),c.getGender(),c.getAge(),c.getAddress(),c.getCity(),c.getNationality(),c.getMobileNo(),c.getEmailId(),c.getHistory()};
		int rows=jdbctemplate.update(query, insert);
		logger.info("Row Inserted:"+rows);
	}
	
	public int updateCandidates(Candidate c) {
		System.out.println("Update Candidate Details");
		String query="update Candidate set candidate_name=? where candidate_id=?";
		Object up[]= {c.getData(),c.getCandidateId()};
		int rows=jdbctemplate.update(query, up);
		logger.info("Row Updated:"+rows);
		return rows;
		
	}
	
	public void deleteCandidates(Candidate c) {
		System.out.println("Delete Candidate Details");
		String query="delete from Candidate where candidate_id=?";
		Object dlt[]= {c.getCandidateId()};
		int rows=jdbctemplate.update(query, dlt);
		System.out.println("Row Deleted:"+rows);
	}
	
	public List<Candidate> viewCandidates(){
		String sql = "select * from Candidate";
		List<Candidate> candidateList = (List<Candidate>) jdbctemplate.query(sql, new CandidateMapper());
		System.out.println(candidateList+"Fetched records");
		return candidateList;
	}
	
	//Election
	public void addElection(Admin a) {
		System.out.println("To Add Election");
		String query="insert into Election(election_id,election_type,election_date)values (?,?,?)";
		Object insert[]= {a.getElectionId(),a.getElectionName(),a.getElectionDate()};
		int rows=jdbctemplate.update(query, insert);
		System.out.println("Row Inserted:"+rows);
	}
	
	public void deleteElection(Admin a) {
		System.out.println("Delete Election");
		String query="delete from Election where election_id=?";
		Object dlt[]= {a.getElectionId()};
		int rows=jdbctemplate.update(query, dlt);
		System.out.println("Row Deleted:"+rows);
	}
	
	//Vote count
	public List<VoteCount> viewResult(){
		String sql = "select party_name,count from VoteCount where count=(select Max(count) from voteCount) ;";
		List<VoteCount> countList = (List<VoteCount>) jdbctemplate.query(sql, new VoteCountMapper());
		System.out.println(countList+"Fetched records");
		return countList;
	}
	
	
}

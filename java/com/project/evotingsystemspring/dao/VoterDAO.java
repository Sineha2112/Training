package com.project.evotingsystemspring.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.project.evotingsystemspring.connection.ConnectionUtil;
import com.project.evotingsystemspring.daointerface.VoterInterface;
import com.project.evotingsystemspring.mapper.ElectionNameMapper;
import com.project.evotingsystemspring.mapper.LoginVoterMapper;
import com.project.evotingsystemspring.mapper.MailIdMapper;
import com.project.evotingsystemspring.mapper.MobileNoMapper;
import com.project.evotingsystemspring.mapper.PartyNameMapper;
import com.project.evotingsystemspring.mapper.PerVoteMapper;
import com.project.evotingsystemspring.mapper.RandomIdNRIMapper;
import com.project.evotingsystemspring.mapper.VoterIdMapper;
import com.project.evotingsystemspring.mapper.VoterMapper;
import com.project.evotingsystemspring.model.Admin;
import com.project.evotingsystemspring.model.Candidate;
import com.project.evotingsystemspring.model.CastingVote;
import com.project.evotingsystemspring.model.NRIVoter;
import com.project.evotingsystemspring.model.Voter;
import com.project.evotingsystemspring.validation.ValidationVs;

public class VoterDAO implements VoterInterface {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	Logger logger = LoggerFactory.getLogger(VoterDAO.class);

	ValidationVs validation = new ValidationVs();

	//NRI voter registration
	public void nriVoterRegister(NRIVoter nVoter,HttpSession session) {
		logger.info("To Register NRI User");
		
		Date dob=nVoter.getNriDateOfBirth();
		Integer age=validation.ageCalculator(dob);
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

	
	// existing emailId
	public Boolean emailExist(Voter voter,Model model) {
		String email = voter.getEmailId();
		String query = "select email_id from ResidentVoter";
		List<Voter> voterList = jdbcTemplate.query(query, new MailIdMapper());
		for (Voter voterli : voterList) {
			String mailId = voterli.getEmailId();
			if (mailId.equals(email)) {
				String errorMessage = "Email Id Already exist ";
				model.addAttribute("errorMessage16", errorMessage);
				return false;

			} else
				logger.info("Valid Email");
		}
		return true;
	}

	// existing mobileNo
	public Boolean mobileNoExist(Voter voter,Model model)  {
		Long mobileNo = voter.getMobileNumber();

		String query = "select mobileNumber from ResidentVoter where mobileNumber=?";
		List<Voter> voterList = jdbcTemplate.query(query, new MobileNoMapper(), mobileNo);
		for (Voter voterli : voterList) {
			Long mNo = voterli.getMobileNumber();
			if (mNo.equals(mobileNo)) {
				String errorMessage = "Mobile Number Already exist ";
				model.addAttribute("errorMessage17", errorMessage);
				return false;

			} else
				logger.info("Valid Mobile Number");
		}
		return true;
	}
	
	// existing voterId
		public Boolean voterIdExist(Voter voter,Model model)  {
			String voterId = voter.getVoterId();

			String query = "select voter_id from ResidentVoter where voter_id=?";
			List<Voter> voterList = jdbcTemplate.query(query, new VoterIdMapper(), voterId);
			for (Voter voterli : voterList) {
				String vId = voterli.getVoterId();
				if (vId.equals(voterId)) {
					String errorMessage = "Voter Id Already exist ";
					model.addAttribute("errorMessage18", errorMessage);
					return false;

				} else
					logger.info("Valid Voter Id");
			}
			return true;
		}

		//Voter login
	public Boolean voterLogin(Voter voter, HttpSession session, Model model) {
		logger.info("To login");
		String status;
		String vId = voter.getVoterId();
		String pass = voter.getUserPassword();
		String query = "select voter_name,voter_id,voter_password from ResidentVoter where voter_id=?";
		List<Voter> userList = jdbcTemplate.query(query, new LoginVoterMapper(), vId);
		for (Voter voterli : userList) {
			if (voterli != null) {
				String voterId = voterli.getVoterId();
				if (voterId.equals(vId)) {
					String password = voterli.getUserPassword();
					if (pass.equals(password)) {
						status = "Success";
						String name = voterli.getVoterName();
						session.setAttribute("VoterId", voterId);
						session.setAttribute("userName", name);
						model.addAttribute("loginstatus", status);
						return true;
					}
				} else {
					status = "InvalidCredentials";
					model.addAttribute("invalidLoginStatus", status);
					return false;
				}
			}
		}
		return false;
	}

	// forget password
	public void forgetPassword(Voter voter) {
		logger.info("Update User password");

		String p1 = voter.getUserPassword();
		String p2 = voter.getNewPassword();
		if (p1.equals(p2)) {
			String query = "update ResidentVoter set voter_password=? where email_id=?";
			Object[] upd = { p1, voter.getEmailId() };
			jdbcTemplate.update(query, upd);
			logger.info("Row Updated");
		} else {
			logger.info("Password doesn't match");
		}
	}

	// view user profile
	public void viewProfile(HttpSession session) {
		String voterid = (String) session.getAttribute("VoterId");

		String sql = "select user_id,voter_name,date_of_birth,age,voter_id,father_name,gender,address,city,nationality,mobileNumber,email_id from ResidentVoter where voter_id=?";
		List<Voter> userList = jdbcTemplate.query(sql, new VoterMapper(), voterid);
		for (Voter v : userList) {
			Integer id = v.getUserId();
			session.setAttribute("Id", id);

			String name = v.getVoterName();
			session.setAttribute("name", name);

			Date dob = v.getDateOfBirth();
			session.setAttribute("dob", dob);

			Integer age = v.getAge();
			session.setAttribute("age", age);

			String vId = v.getVoterId();
			session.setAttribute("vId", vId);

			String fatherName = v.getFatherName();
			session.setAttribute("fName", fatherName);

			String gender = v.getGender();
			session.setAttribute("gender", gender);

			String address = v.getAddress();
			session.setAttribute("address", address);

			String city = v.getCity();
			session.setAttribute("city", city);

			String nationality = v.getNationality();
			session.setAttribute("nationality", nationality);

			Long mNo = v.getMobileNumber();
			session.setAttribute("mobileNo", mNo);

			String email = v.getEmailId();
			session.setAttribute("emailId", email);

		}
		logger.info(userList + "voter profile records");

	}

	// edit user profile
	public int updateProfile(Voter voter, HttpSession session) {
		logger.info("Update User Profile");
		Integer id = (Integer) session.getAttribute("Id");

		String query = "update ResidentVoter set mobileNumber=?,email_id=? where user_id=?";
		Object[] upd = { voter.getMobileNumber(), voter.getEmailId(), id };
		int rows = jdbcTemplate.update(query, upd);
		logger.info("Row Updated");
		return rows;
	}

	// dynamic dropdown for party name
	public List<String> dynamicPartyName() {
		logger.info("To have dynamic party name");
		String query = "select party_name from Candidate";
		List<Candidate> partList = jdbcTemplate.query(query, new PartyNameMapper());
		List<String> partyName = new ArrayList<>();
		for (Candidate pList : partList) {
			partyName.add(pList.getCandidatePartyName());
		}
		return partyName;

	}

	//dynamic dropdown from election name
	public List<String> dynamicElectionName(){
		logger.info("To have dynamic Election name");
		String query = "select election_type from Election";
		List<Admin> electionList = jdbcTemplate.query(query, new ElectionNameMapper());
		List<String> electionName = new ArrayList<>();
		for (Admin eList : electionList) {
			electionName.add(eList.getElectionName());
		}
		return electionName;
	}
	
	// insert votes information
	public void castVote(CastingVote castvote, HttpSession session) {
		logger.info("To Cast Vote");
		String query = "insert into CastingVote(election_type,voter_id,party_name,vote) values (?,?,?,?)";
		Object[] vote = { castvote.getElectionType(), castvote.getVoterId(), castvote.getPartyName(),
				castvote.getVote() };
		session.setAttribute("eName", castvote.getElectionType());
		jdbcTemplate.update(query, vote);
		logger.info("Voted");

	}

	// UserId validation for one vote
	public Boolean userIdPerVote(CastingVote castVote,Model model)  {
		String vId = castVote.getVoterId();
		logger.info(vId);
		String query = "select voter_id from CastingVote";
		List<CastingVote> uIdVote = jdbcTemplate.query(query, new PerVoteMapper());
		for (CastingVote voterli : uIdVote) {
			String voterId = voterli.getVoterId();
			if (vId.equals(voterId)) {
				logger.info("You are already voted");
				String errorMessage = "You Have Already Voted";
				model.addAttribute("error", errorMessage);
				return false;

			} else
				logger.info("Continue");
		}
		return true;
	}

	//voter feedback
	public void addFeedback(Voter voter) {
		logger.info("To Add Feedback");
		String query = "insert into Feedback(user_id,feedback,rating) values(?,?,?)";
		Object[] reg = { voter.getUserId(), voter.getFeedback(), voter.getRate() };
		jdbcTemplate.update(query, reg);
		logger.info("Feedback Inserted");
	}

	//voter complaints
	public void addComplaints(Voter voter) {
		logger.info("To Add Complaints");
		String query = "insert into userComplaints(user_id,party_name,complaints) values(?,?,?)";
		Object[] reg = { voter.getUserId(), voter.getPartyName(), voter.getComplaints() };
		jdbcTemplate.update(query, reg);
		logger.info("Reports Inserted");
	}

	//election date
	public boolean gettingElectionDate(Model model) {

		logger.info("To get election date");
		String query = "select election_date from Election";
		Date userList = jdbcTemplate.queryForObject(query,Date.class);

		
		model.addAttribute("EDATE", userList);
		LocalDate date = java.time.LocalDate.now();

		String date1 = date.toString();
		return Optional.ofNullable(userList)
	               .map(u -> {
	                   if (date1.equals(u.toString())) {
	                       logger.info("Both dates are equal");
	                       return true;
	                   } else {
	                       logger.info("Not equal");
	                       return false;
	                   }
	               })
	               .orElse(false);
	}

}

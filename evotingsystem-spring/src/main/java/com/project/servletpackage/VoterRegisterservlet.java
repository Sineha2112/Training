package com.project.servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.model.Voter;
import com.chain.myexception.InvalidAddressException;
import com.chain.myexception.InvalidAgeException;
import com.chain.myexception.InvalidCityException;
import com.chain.myexception.InvalidDobException;
import com.chain.myexception.InvalidEmailIdException;
import com.chain.myexception.InvalidGenderException;
import com.chain.myexception.InvalidMobileNoException;
import com.chain.myexception.InvalidNameException;
import com.chain.myexception.InvalidNationalityException;
import com.chain.myexception.InvalidPasswordException;
import com.chain.myexception.InvalidVoterIdException;
import com.chain.validation.ValidationVs;


@WebServlet("/VoterRegisterservlet")
public class VoterRegisterservlet extends HttpServlet {

	Voter v = new Voter();
	ValidationVs vs=new ValidationVs();
	
	private static final long serialVersionUID = 1L;

	public VoterRegisterservlet() {
		super();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
				System.out.println(con);

				String name = v.setVoterName(request.getParameter("name"));
				try {
					vs.nameValidation(name);
				} catch (InvalidNameException e1) {
					e1.printStackTrace();
				}
				response.getWriter();

				String date = request.getParameter("dob");
				try {
					vs.dateOfBirthValidation(date);
					v.setDateOfBirth(date);
				} catch (InvalidDobException e1) {
					e1.printStackTrace();
				}
				response.getWriter();
			
					Date dt=(Date) new SimpleDateFormat("yyyy-MM-dd").parse(date);
					
				
			  
			    
				Integer age = Integer.parseInt(request.getParameter("age"));
				try {
					vs.ageValidation(date);
				} catch (InvalidAgeException e) {
					e.printStackTrace();
				}
				v.setAge(age);
				response.getWriter();
				
				String voterId = v.setVoterId(request.getParameter("voterId"));
				try {
					vs.voterIdValidation(voterId);
				} catch (InvalidVoterIdException e) {
					e.printStackTrace();
				}
				response.getWriter();

				String fatherName = v.setFatherName(request.getParameter("fatherName"));
				try {
					vs.fatherNameValidation(fatherName);
				} catch (InvalidNameException e) {
					e.printStackTrace();
				}
				response.getWriter();

				String gender = v.setGender(request.getParameter("gender"));
				try {
					vs.genderValidation(gender);
				} catch (InvalidGenderException e) {
					e.printStackTrace();
				}
				response.getWriter();

				String address = v.setAddress(request.getParameter("address"));
				try {
					vs.addressValidation(address);
				} catch (InvalidAddressException e) {
					e.printStackTrace();
				}
				response.getWriter();

				String city =v.setCity(request.getParameter("city"));
				try {
					vs.cityValidation(city);
				} catch (InvalidCityException e) {
					e.printStackTrace();
				}
				response.getWriter();

				String nationality =v.setNationality(request.getParameter("nationality"));
				try {
					vs.nationalityValidation(nationality);
				} catch (InvalidNationalityException e) {
					e.printStackTrace();
				}
				response.getWriter();

				Long mobileNo = Long.parseLong(request.getParameter("mobileNumber"));
				try {
					vs.phoneNoValidation(mobileNo);
				} catch (InvalidMobileNoException e) {
					e.printStackTrace();
				}
				v.setMobileNumber(mobileNo);
				response.getWriter();

				String email =v.setEmailId(request.getParameter("email"));
				try {
					vs.emailValidation(email);
				} catch (InvalidEmailIdException e) {
					e.printStackTrace();
				}
				response.getWriter();

				String password =v.setUserPassword( request.getParameter("password"));
				try {
					vs.passwordValidation(password);
				} catch (InvalidPasswordException e) {
					e.printStackTrace();
				}
				response.getWriter();

				Integer randomId = (int) ((float) Math.random() * 1000);
				v.setUserId(randomId);
				System.out.println("Your User Id id: " + randomId);

				String query = "insert into Voter(user_id,voter_name,date_of_birth,age,voter_id,father_name,gender,address,city,nationality,mobileNumber,email_id,voter_password) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(query);

				// getting & setting values
				ps.setInt(1, v.getUserId());
				ps.setString(2,v.getVoterName());

				ps.setDate(3,dt);
				ps.setInt(4,v.getAge());
				ps.setString(5, v.getVoterId());
				ps.setString(6, v.getFatherName());
				ps.setString(7, v.getGender());
				ps.setString(8, v.getAddress());
				ps.setString(9, v.getCity());
				ps.setString(10, v.getNationality());
				ps.setLong(11, v.getMobileNumber());
				ps.setString(12, v.getEmailId());
				ps.setString(13, v.getUserPassword());
				
				Integer rows = ps.executeUpdate();
				System.out.println("Rows inserted: " + rows);
				request.getRequestDispatcher("voterhomepage.jsp").forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ParseException e1) { 
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

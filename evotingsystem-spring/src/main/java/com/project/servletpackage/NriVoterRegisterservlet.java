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

import com.chain.model.NriVoter;
import com.chain.myexception.InvalidAgeException;
import com.chain.myexception.InvalidCityException;
import com.chain.myexception.InvalidDobException;
import com.chain.myexception.InvalidEmailIdException;
import com.chain.myexception.InvalidGenderException;
import com.chain.myexception.InvalidNameException;
import com.chain.myexception.InvalidNationalityException;
import com.chain.myexception.InvalidPasswordException;
import com.chain.myexception.InvalidVoterIdException;
import com.chain.validation.ValidationVs;




@WebServlet("/NriVoterRegisterservlet")
public class NriVoterRegisterservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   NriVoter n=new NriVoter();
   ValidationVs vs=new ValidationVs();
    public NriVoterRegisterservlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date2 = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
				System.out.println(con);

				String name = request.getParameter("name");
				try {
					vs.nameValidation(name);
				} catch (InvalidNameException e1) {
					e1.printStackTrace();
				}
				n.setVoterName(name);
				response.getWriter();

				String date = request.getParameter("dob");
				try {
					vs.dateOfBirthValidation(date);
				} catch (InvalidDobException e1) {
					e1.printStackTrace();
				}
				response.getWriter();
				try {
					date2 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);
					System.out.println(date2);

				} catch (ParseException e) {

					e.printStackTrace();
				}
			  
			    
				Integer age = Integer.parseInt(request.getParameter("age"));
				try {
					vs.ageValidation(date);
				} catch (InvalidAgeException e) {
					e.printStackTrace();
				}
				n.setAge(age);
				response.getWriter();
				
				String voterId = request.getParameter("voterId");
				try {
					vs.voterIdValidation(voterId);
				} catch (InvalidVoterIdException e) {
					e.printStackTrace();
				}
				n.setVoterId(voterId);
				response.getWriter();

				String fatherName =request.getParameter("fatherName");
				try {
					vs.fatherNameValidation(fatherName);
				} catch (InvalidNameException e) {
					e.printStackTrace();
				}
				n.setFatherName(fatherName);
				response.getWriter();

				String gender =request.getParameter("gender");
				try {
					vs.genderValidation(gender);
				} catch (InvalidGenderException e) {
					e.printStackTrace();
				}
				n.setGender(gender);
				response.getWriter();

				String nationality=request.getParameter("nationality");
				try {
					vs.nationalityValidation(nationality);
				} catch (InvalidNationalityException e) {
					e.printStackTrace();
				}
				n.setNationality(nationality);
				response.getWriter();

				String state =request.getParameter("state");
				try {
					vs.stateValidation(state);
				} catch (InvalidNameException e1) {
					e1.printStackTrace();
				}
				n.setState(state);
				response.getWriter();

				String city =request.getParameter("city");
				try {
					vs.cityValidation(city);
				} catch (InvalidCityException e) {
					e.printStackTrace();
				}
				n.setCity(city);
				response.getWriter();
				
				String email =request.getParameter("email");
				try {
					vs.emailValidation(email);
				} catch (InvalidEmailIdException e) {
					e.printStackTrace();
				}
				n.setEmailId(email);
				response.getWriter();

				String password = request.getParameter("password");
				try {
					vs.passwordValidation(password);
				} catch (InvalidPasswordException e) {
					e.printStackTrace();
				}
				n.setUserPassword(password);
				response.getWriter();

				Integer randomId = (int) ((float) Math.random() * 1000);
		    	n.setNriId(randomId);
				System.out.println("Your User Id id: " + randomId);

				String query = "insert into NRIVoter(user_id,voter_name,date_of_birth,age,voter_id,father_name,gender,nationality,state,city,email_id,voter_password) values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(query);

				// getting & setting values
				ps.setInt(1, n.getNriId());
				ps.setString(2,n.getVoterName());
				ps.setDate(3,date2);
				ps.setInt(4,n.getAge());
				ps.setString(5, n.getVoterId());
				ps.setString(6, n.getFatherName());
				ps.setString(7, n.getGender());
				ps.setString(8, n.getNationality());
				ps.setString(9, n.getState());
				ps.setString(10, n.getCity());
				ps.setString(11, n.getEmailId());
				ps.setString(12, n.getUserPassword());
				Integer rows = ps.executeUpdate();
				// rows inserted msg with number
				System.out.println("Rows inserted: " + rows);
				request.getRequestDispatcher("voterhomepage.jsp").forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

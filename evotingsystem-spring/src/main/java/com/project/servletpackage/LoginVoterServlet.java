package com.project.servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chain.model.Voter;



@WebServlet("/LoginVoterServlet")
public class LoginVoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Voter v=new Voter();
    
    public LoginVoterServlet() {
        super();
           }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
	           Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	           System.out.println(con);
	           
	           String voterId=request.getParameter("VoterId");
	           v.setVoterId(voterId);
	           PrintWriter writer = response.getWriter();
	           
	           String password=request.getParameter("password");
	           v.setUserPassword(password);
	           response.getWriter();
	           
	          
	   		//views name & password
	   		String query="select voter_id,voter_password from Voter where voter_id=?";
	   		PreparedStatement ps=con.prepareStatement(query);
	   		ps.setString(1, voterId);
	   		ResultSet rs=ps.executeQuery();
	   		while(rs.next()) {
	   			//getting values from the database & checks if it exist
	   			String uId=rs.getString("voter_id");
	   			if(voterId.equals(uId)) {
	   				String uPass=rs.getString("voter_password");
	   				
	   				if(uPass.equals(password)) {
	   					
	   					writer.println("Login Successful");
						/*
						 * String ses=request.getParameter("VoterId"); HttpSession
						 * session=request.getSession(true); session.setAttribute("VoterId", ses);
						 */
	   					request.getRequestDispatcher("voterhomepage.jsp").forward(request, response);
	   				}
	   				else
	   					throw new Error("Invalid Password");
	   				}
	   			else {
	   				throw new Error("Invalid Voter Id or Password");
	   			}
	   			}
	}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

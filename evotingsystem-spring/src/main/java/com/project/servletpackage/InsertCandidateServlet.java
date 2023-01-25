package com.project.servletpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.model.Candidate;


@WebServlet("/InsertCandidateServlet")
public class InsertCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Candidate c=new Candidate();
	
    public InsertCandidateServlet() {
        super();
       
    }
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
				System.out.println(con);
				
				Integer id=Integer.parseInt(request.getParameter("id"));
				c.setCandidateId(id);
				response.getWriter();
				
				String partyName=request.getParameter("partyName");
				c.setPartyName(partyName);
				response.getWriter();
				
				String partySymbol=request.getParameter("partySymbol");
				c.setPartySymbol(partySymbol);
				response.getWriter();
				
				String name=request.getParameter("name");
				c.setCandidateName(name);
				response.getWriter();
				
				String gender=request.getParameter("gender");
				c.setGender(gender);
				response.getWriter();
				
				Integer age=Integer.parseInt(request.getParameter("age"));
				c.setAge(age);
				response.getWriter();
				
				String address=request.getParameter("address");
				c.setAddress(address);
				response.getWriter();
				
				String city=request.getParameter("city");
				c.setCity(city);
				response.getWriter();
				
				String nationality=request.getParameter("nationality");
				c.setNationality(nationality);
				response.getWriter();
				
				Long mobileNo=Long.parseLong(request.getParameter("mobileNumber"));
				c.setMobileNo(mobileNo);
				response.getWriter();
				
				String email=request.getParameter("email");
				c.setEmailId(email);
				response.getWriter();
				
				String history=request.getParameter("history");
				c.setHistory(history);
				response.getWriter();
				
				String query="insert into Candidate(candidate_id,party_name,party_symbol,candidate_name,gender,age,address,city,nationality,mobileNo,emailId,history) values(?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				//getting & setting the values
				ps.setInt(1,c.getCandidateId());
				ps.setString(2,c.getPartyName());
				ps.setString(3, c.getPartySymbol());
				ps.setString(4, c.getCandidateName());
				ps.setString(5,c.getGender());
				ps.setInt(6, c.getAge());
				ps.setString(7, c.getAddress());
				ps.setString(8, c.getCity());
				ps.setString(9, c.getNationality());
				ps.setLong(10, c.getMobileNo());
				ps.setString(11, c.getEmailId());
				ps.setString(12,c.getHistory());
	
				int rows=ps.executeUpdate();
				System.out.println("Rows Inserted: "+rows);
				request.getRequestDispatcher("adminpage.jsp").forward(request, response);

				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

package com.chain.servletpackage;

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

import com.chain.model.Admin;


@WebServlet("/AddElectionServlet")
public class AddElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Admin a=new Admin();
    
    public AddElectionServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
				System.out.println(con);
				
				Integer id=Integer.parseInt(request.getParameter("id"));
				a.setElectionId(id);
				response.getWriter();
				
				String name=request.getParameter("name");
				a.setElectionName(name);
				response.getWriter();
				
				String date=request.getParameter("date");
				a.setElectionDate(date);
				response.getWriter();
				
				String query="insert into Election(election_id,election_type,election_date) values(?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, a.getElectionId());
				ps.setString(2, a.getElectionName());
				ps.setString(3, a.getElectionDate());
				
				Integer rows = ps.executeUpdate();
				System.out.println("Rows inserted: " + rows);
				request.getRequestDispatcher("adminpage.jsp").forward(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

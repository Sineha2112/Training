package com.project.servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class DeleteElectionServlet
 */
@WebServlet("/DeleteElectionServlet")
public class DeleteElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Admin a=new Admin();
   
    public DeleteElectionServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
	           Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	           System.out.println(con);
	           
	           Integer id=Integer.parseInt(request.getParameter("id"));
	           a.setElectionId(id);
	           PrintWriter writer = response.getWriter();

		    	a.getElectionId();
				String query="delete from Election where election_id=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, id);
				
				int rows=ps.executeUpdate();
				System.out.println("Rows deleted: "+rows);
				
				request.getRequestDispatcher("adminpage.jsp").forward(request, response);
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

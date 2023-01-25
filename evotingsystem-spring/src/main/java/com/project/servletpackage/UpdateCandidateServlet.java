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


@WebServlet("/UpdateCandidateServlet")
public class UpdateCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Candidate c=new Candidate();
    
    public UpdateCandidateServlet() {
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
				
				String changeData=request.getParameter("changeData");
				c.setData(changeData);
				response.getWriter();
				
				c.getCandidateId();
				c.getData();
				String query="update Candidate set candidate_name=? where candidate_id=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, changeData);
				ps.setInt(2, id);
				int rows=ps.executeUpdate();
				System.out.println("Rows updated: "+rows);
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

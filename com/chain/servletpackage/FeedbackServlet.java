package com.chain.servletpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.model.Voter;


@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	Voter v=new Voter();
	
    public FeedbackServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
				System.out.println(con);

				Integer id=Integer.parseInt(request.getParameter("id"));
				v.setUserId(id);
				
				String feedback=request.getParameter("feedback");
				v.setComplaints(feedback);
				
				String query="insert into Feedback(user_id,complaints) values(?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, v.getUserId());
				ps.setString(2,v.getComplaints());
				int rows=ps.executeUpdate();
				System.out.println("Rows Inserted:"+rows);
				
			} catch (SQLException e) {
				e.printStackTrace();
		} 
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
}
}
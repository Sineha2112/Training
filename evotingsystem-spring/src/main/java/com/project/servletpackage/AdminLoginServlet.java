package com.project.servletpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.model.Admin;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Admin a=new Admin();
    
    public AdminLoginServlet() {
        super();
        
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
	           Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	           System.out.println(con);
	           
	           String adminId=request.getParameter("adminId");
	           a.setAdminId(adminId);
	           PrintWriter writer = response.getWriter();
	           
	           String password=request.getParameter("password");
	           a.setPassword(password);
	           response.getWriter();
	           
	           String query="select admin_id,password from Admin";
	   			if(a.getAdminId().equals("admin")) {
	   			if(a.getPassword().equals("admin123")) {
	   				writer.println("Login Successful");
	   				/*
					 * String ses=request.getParameter("VoterId"); HttpSession
					 * session=request.getSession(true); session.setAttribute("VoterId", ses);
					 */
   					request.getRequestDispatcher("adminpage.jsp").forward(request, response);
	   			}
	   			else
	   				writer.println("Invalid password");
	   		}
	   		else {
	   			writer.println("Invalid Admin Id or Password");
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

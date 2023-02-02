package com.chain.servletpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MaxCountServlet")
public class MaxCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MaxCountServlet() {
        super();
       
    }

	
/*Expense calculation--->1st Candidate have to register themselves and in the registration process they have to submit the
 * expense details if the exceed the expense of 10,000 they admin ask for the explanation if the explanation is valid they can 
 * enter the election,if it isn't the candidate is removed from the election
 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
				System.out.println(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

				
	}

}

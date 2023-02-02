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

import com.chain.model.Admin;
import com.chain.model.Candidate;
import com.chain.model.CastingVote;
import com.chain.model.NriVoter;
import com.chain.model.Voter;


@WebServlet("/CastVoteServlet")
public class CastVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Voter v=new Voter();
    Candidate c=new Candidate();
   CastingVote cv=new CastingVote();
   NriVoter n=new NriVoter();
   Admin a=new Admin();
   
    public CastVoteServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
				System.out.println(con);
				
				String electionName=request.getParameter("electionName");
				a.setElectionName(electionName);
				response.getWriter();
				
				String type=request.getParameter("type");
				v.setVoterType(type);
				response.getWriter();
				String vtype=v.getVoterType();
				
				String partyName=request.getParameter("partyName");
				c.setPartyName(partyName);
				response.getWriter();
				
				String vote=request.getParameter("vote");
				cv.setVote(vote);
				response.getWriter();
				
				if(vtype.equals("Resident Voter")) {
					Integer id=Integer.parseInt(request.getParameter("id"));
					v.setUserId(id);
					
					String query="insert into CastingVote(election_type,user_id,party_name,vote) values (?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, a.getElectionName());
					ps.setInt(2, v.getUserId());
					ps.setString(3,c.getPartyName());
					ps.setString(4, cv.getVote());
				    ps.executeUpdate();
					System.out.println("**Thank you!!!**");
					request.getRequestDispatcher("voterhomepage.jsp").forward(request, response);
				}
				else if(vtype.equals("Non-Resident Voter")){
					Integer id=Integer.parseInt(request.getParameter("id"));
					n.setNriId(id);
					
					String query="insert into CastingVote(election_type,user_id,party_name,vote) values (?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, a.getElectionName());
					ps.setInt(2, n.getNriId());
					ps.setString(3,c.getPartyName());
					ps.setString(4, cv.getVote());
				    ps.executeUpdate();
					System.out.println("**Thank you!!!**");
					request.getRequestDispatcher("voterhomepage.jsp").forward(request, response);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

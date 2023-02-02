<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center;">Candidates List</h1>
	<%Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle"); 
	String query="select * from Candidate";
	PreparedStatement ps=con.prepareStatement(query);
	ResultSet rs=ps.executeQuery();
	%>
	<table>
	<thead>
	<tr>
	<th>Election Id</th> 
	<th>Candidate Id</th>
	<th>Party Name</th>
	<th>Party Symbol</th>
	<th>Candidate Name</th>
	<th>Gender</th>
	<th>Age</th>
	<th>Address</th>
	<th>City</th>
	<th>Nationality</th>
	<th>Mobile Number</th>
	<th>Email Id</th>
	<th>History</th>
	</tr>
	</thead>
	<tbody>
	<%while(rs.next()){%>
		<tr>
		<%-- <td><%=rs.getInt(1)%></td> --%>
		<td><%=rs.getInt(1) %></td>
		<td><%=rs.getInt(2) %>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getString(4) %></td>
		<td><%=rs.getString(5) %></td>
		<td><%=rs.getString(6) %></td>
		<td><%=rs.getInt(7) %></td>
		<td><%=rs.getString(8) %></td>
		<td><%=rs.getString(9) %></td>
		<td><%=rs.getString(10) %></td>
		<td><%=rs.getLong(11) %></td>
		<td><%=rs.getString(12) %></td>
		<td><%=rs.getString(13) %></td>
		</tr>
	<%}%>
	</tbody>
	</table>
</body>
</html>
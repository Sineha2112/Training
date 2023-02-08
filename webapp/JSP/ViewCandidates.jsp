<%@page import="com.project.evotingsystemspring.model.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List <Candidate> n = (List<Candidate>)request.getAttribute("CANDIDATE_LIST");
	%>
<h1 style="text-align:center;">Candidates List</h1>
	
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
	
		<tr>
		<td><%=rs.getInt(1)%></td> 
		<td><%=rs.getInt(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getString(4) %></td>
		<td><%=rs.getString(5) %></td>
		<td><%=rs.getInt(6) %></td>
		<td><%=rs.getString(7) %></td>
		<td><%=rs.getString(8) %></td>
		<td><%=rs.getString(9) %></td>
		<td><%=rs.getLong(10) %></td>
		<td><%=rs.getString(11) %></td>
		<td><%=rs.getString(12) %></td>
		</tr>
	
	</tbody>
	</table>
</body>
</html>
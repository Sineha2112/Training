<%@page import="com.project.evotingsystemspring.model.Voter"%>
<%@page import="java.util.List"%>
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
<title>View Profile</title>
</head>
<body>
<h1 style="text-align:center">User Profile</h1>
	<%
List <Voter> voter = (List<Voter>)request.getAttribute("USER_LIST");
	%>
	<form action="/viewUser">
	<table>
	<thead>
	<tr>
	<th>User Id</th>
	<th>Voter Name</th>
	<th>Date Of Birth</th>
	<th>Age</th>
	<th>Voter Id</th>
	<th>Father Name</th>
	<th>Gender</th>
	<th>Address</th>
	<th>City</th>
	<th>Nationality</th>
	<th>Mobile Number</th>
	<th>Email Id</th>
	<th>Password</th>
	</tr>
	</thead>
	<tbody>
	<%
		for (Voter userlist:voter){
	%>
		<tr>
		<td><%=userlist.getUserId()%></td>
		<td><%=userlist.getVoterName() %></td>
		<td><%=userlist.getDateOfBirth() %></td>
		<td><%=userlist.getAge() %></td>
		<td><%=userlist.getVoterId() %></td>
		<td><%=userlist.getFatherName() %></td>
		<td><%=userlist.getGender() %></td>
		<td><%=userlist.getAddress() %></td>
		<td><%=userlist.getCity() %></td>
		<td><%=userlist.getNationality() %></td>
		<td><%=userlist.getMobileNumber() %></td>
		<td><%=userlist.getEmailId() %></td>
		<td><%=userlist.getUserPassword() %></td>
		</tr>
	<%}%>
	</tbody>
	</table>
	</form>
</body>
</html>
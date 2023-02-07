<%@page import="com.project.evotingsystemspring.model.NriVoter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View NriVoter Profile</title>
</head>
<body>
	<%
List <NriVoter> n = (List<NriVoter>)request.getAttribute("USER_LIST");
	%>
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
	<th>Nationality</th>
	<th>State</th>
	<th>City</th>
	<th>Email Id</th>
	<th>Password</th>
	</tr>
	</thead>
	<tbody>
	<%
		for (NriVoter userlist:n){
	%>
		<tr>
		<td><%=userlist.getNriId()%></td>
		<td><%=userlist.getVoterName() %></td>
		<td><%=userlist.getDateOfBirth() %></td>
		<td><%=userlist.getAge() %></td>
		<td><%=userlist.getVoterId() %></td>
		<td><%=userlist.getFatherName() %></td>
		<td><%=userlist.getGender() %></td>
		<td><%=userlist.getNationality()%></td>
		<td><%=userlist.getState() %></td>
		<td><%=userlist.getCity() %></td>
		<td><%=userlist.getEmailId() %></td>
		<td><%=userlist.getUserPassword() %></td>
		</tr>
	<%}%>
	</tbody>
	</table>
</body>
</html>
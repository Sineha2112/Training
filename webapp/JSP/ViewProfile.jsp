<%@page import="java.sql.Date"%>
<%@page import="com.project.evotingsystemspring.model.Voter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Profile</title>
<style>
table{
border-collapse: collapse;
  width: 100%;
 
  }
th,td{
 text-align: left;
  padding: 5px;
  border: 2px solid #ddd;
	background-color:lavender;
}

</style>
</head>
<%HttpSession session1=request.getSession();%>
<%Integer id=(Integer)session1.getAttribute("Id"); %>
<%String str=(String)session1.getAttribute("name"); %>
<%Date dob=(Date)session1.getAttribute("dob"); %>
<%Integer age=(Integer)session1.getAttribute("age"); %>
<%String vId=(String)session1.getAttribute("voterId"); %>
<%String fName=(String)session1.getAttribute("fName"); %>
<%String gender=(String)session1.getAttribute("gender"); %>
<%String address=(String)session1.getAttribute("address"); %>
<%String city=(String)session1.getAttribute("city"); %>
<%String nationality=(String)session1.getAttribute("nationality"); %>
<%Long mobile=(Long)session1.getAttribute("mobileNo"); %>
<%String email=(String)session1.getAttribute("emailId"); %>

<body>
<h1 style="text-align:center">User Profile</h1>
	
	<form>
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
	
	</tr>
	</thead>
	<tbody>
		<tr>
		<td><%=id %></td>
		<td><%=str %></td>
		<td><%=dob%></td>
		<td><%=age %></td>
		<td><%=vId %></td>
		<td><%=fName %></td>
		<td><%=gender %></td>
		<td><%=address %></td>
		<td><%=city %></td>
		<td><%=nationality %></td>
		<td><%=mobile %></td>
		<td><%=email %></td>
		
		</tr>
	</tbody>
	</table>
	</form>
</body>
</html>
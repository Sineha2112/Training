<%@page import="com.project.evotingsystemspring.model.VoteCount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote Result</title>
</head>
<body>
<h1>The Winner is:</h1>
<%
List <VoteCount> vc = (List<VoteCount>)request.getAttribute("COUNT_LIST");
	%>
	<table>
	<thead>
	<tr>
	<th>Party Name</th>
	<th>Count</th>
	</tr>
	</thead>
	<tbody>
	<%
		for (VoteCount userlist:vc){
	%>
		<tr>
		<td><%=userlist.getPartyName()%></td>
		<td><%=userlist.getCount() %></td>
		</tr>
		<%} %>
	</tbody>
	</table>
</body>
</html>
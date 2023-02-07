<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nri Voter homePage</title>
<link rel="stylesheet" href="/CSS/mainpagestyles.css">
<style>
.session{
text-align:right;
}
</style>
</head>
<%HttpSession session1=request.getSession();%>
<%String str=(String)session1.getAttribute("userName"); %>
<body>

<div class="menu">
	<div class="nav" >
		<a href="JSP/castvote.jsp">Cast Vote</a>
		<a href="ViewCandidates">View Candidates</a>
		<a href="#">View Result</a>
		<a href="JSP/Feedback.jsp">Feedback</a>
		<a href="JSP/Report.jsp">Report</a>
		<a href="JSP/ViewProfile.jsp">View Profile</a>
		<a href="mainpage.jsp">Log Out</a>
		<%-- <form action="/findUserbyId" method="get">
		Enter name:<input type="text" name="name">
		<button type="submit">Submit </button>
		</form>
		<p>ID:${findId}</p> --%>
	</div>
	<div class="session" ><%="Welcome "+str %></div>
	</div><br>
<h1 style="text-align:center;">WELCOME VOTER</h1>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminPage</title>
<link rel="stylesheet" href="adminpagestyles.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	 <div class="AdminMenu">
        <ul class="links">
            <li><a href="#"><i class="fa fa-group"></i><span class="logo">E-Voting</span></a></li>
            <li><a href="#"><i class="fa fa-navicon"></i>Dashboard</a></li>
            <li><a href="#"><i class="fa fa-user-circle"></i>Voters<i class="fa fa-caret-down"></i></a>
            <div class="subMenu1">
            	<ul>
            	<li><a href="ViewProfile.jsp">View Voters Details</a></li>
            	<li><a href="#">Voter's Vote Details</a></li>
            	</ul>
            </div>
            </li>
            <li><a href="#"><i class="fa fa-user-circle"></i>Candidates<i class="fa fa-caret-down"></i></a>
            <div class="subMenu2">
            	<ul>
            	<li><a href="insertCandidates.jsp">Add Candidates</a></li>
            	<li><a href="updateCandidate.jsp">Update Candidates</a></li>
            	<li><a href="deletecandidate.jsp">Delete Candidates</a></li>
            	<li><a href="ViewCandidates.jsp">View Candidates</a></li>
            	</ul>
            </div>
            </li>
            <li><a href="#"><i class="fa fa-university"></i>Election<i class="fa fa-caret-down"></i></a>
            <div class="subMenu3">
            	<ul>
            	<li><a href="addelection.jsp">Add Election</a></li>
            	<li><a href="deleteElection.jsp">Delete Election</a></li>
            	</ul>
            </div>
            </li>
            <li><a href="Feedback.jsp"><i class="fa fa-comments"></i>Feedback</a></li>
            <li><a href="mainpage.jsp"><i class="fa fa-power-off"></i>Log Out</a></li>
        </ul>
        </div> 
        <section class="Home">
            <nav>
                <div class="side">
                    <i class="fa fa-bars"></i> 
                    <span class="dashboard">Dashboard</span>  
                </div>
                <div class="profile">
                    <img src="C:\Users\sine3351\Downloads\Adminimg.jpg" alt="Admin">
                    <span class="adminName">Ram</span>
                    <i class="fa fa-sort-down"></i>
                </div>
            </nav>
        </section>
</body>
</html>
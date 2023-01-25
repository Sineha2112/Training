<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" href="loginstyles.css">
</head>
<body>
	<nav align="right">
            <button type="submit"><a href="mainpage.jsp">Home</a></button>&emsp;<button type="submit"><a href="voterregister.jsp">Register</a></button>
	</nav>
        <div class="container1">
        <h1><center>WELCOME VOTER</center></h1>
        <h3><center>Vote today for a better tomorrow.</center></h3>
    </div>
    <div class="login">
    <section class="signIn">
    <div class="container">
    <div class="signInContent">
    <div class="inImage">
    <figure>
    <img src="C:\Users\sine3351\Downloads\login-project\login-project\images\signin-image.jpg" alt="signIn iamge">
    </figure>
    <a href="nri_voterregister.jsp" class="signUpLink">Create an account</a>
    </div>
    <div class="signInForm">
    <h2>Sign In</h2>
    <form name="Login"  action="LoginNriVoterServlet"  class="loginForm" method="post">
    	<div class="formGrp">
        <label for="voterId"><b>Enter Voter Id:</b></label><br>
        <input type="text" name="VoterId" placeholder="Voter Id" required><br><br> 
        </div>
        <div class="formGrp">   
        <label for="password"><b>Enter password:</b></label><br>
        <input type="password" name="password" placeholder="Password" required><br><br>
        </div>
        <div class="loginButton"><button type="submit">Login</button>&emsp;
       <button type="reset">Cancel</button></div><br>
       <INPUT TYPE="button" VALUE="Back" onClick="history.go(-1);">
       <p>Forgot <a href="forgotp.html">&ensp;Password?</a></p>
    </form>
    </div>
     </div>
     </div>
     </section>
</div>
</body>
</html>
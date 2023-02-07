<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" href="/CSS/loginstyles.css">
</head>
<body>
	<nav align="right">
            <button type="submit"><a href="JSP/mainpage.jsp">Home</a></button>&emsp;<button type="submit"><a href="voterregister.jsp">Register</a></button>
	</nav>
        <div class="container1">
        <h1><center>WELCOME VOTER</center></h1>
        <h3><center>Vote today for a better tomorrow.</center></h3>
    </div>
    
    <div class="main">
   		 <section class="signIn">
   			 <div class="container">
    			<div class="signInContent">
   					 <div class="signinin-image">
					    <figure>
					    <img src="\Images\signin-image.jpg" alt="signIn iamge">
					    </figure>
    <a href="nri_voterregister.jsp" class="signUpLink">Create an account</a>
    </div>
    <div class="signin-form">
    <h2 class="form-title">Sign In</h2>
    
    <form name="Login"  action="/loginNriVoter"  class="loginForm" method="post">
    	<div class="form-group">
        <label for="name"></label><br>
        <input type="text" name="voterId" placeholder="Voter Id" required><br><br> 
        </div>
        
        <div class="form-group">   
       <label for="password"></label><br>
        <input type="password" name="password" placeholder="Password" required><br><br>
        </div>
        
        <div class="form-submit"><button type="submit">Login</button>&emsp;
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
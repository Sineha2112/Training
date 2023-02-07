<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/mainpagestyles.css">
  <link rel="stylesheet" href="CSS/contactusstyless.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>MainPage</title>
</head>
<body background="Images\backgroungImg.jpg">

	<section class="Main">
	<div class="menu">
           <div class="logo"> <img src="Images\logo.jpg""alt="logo">
                <h3 style="text-align:left;">E-VOTING</h3>
            </div>
            
            <div class="nav" >
            <a  class="active" href="#"><i class="fa fa-home"></i>Home</a>
            <a href="JSP/residentvoter.jsp"><i class="fa fa-vcard"></i>Resident Voter</a>
            <a href="JSP/nri_residentvoter.jsp"><i class="fa fa-vcard"></i>Non-Resident Voter</a>
            <a href="JSP/registercandidates.jsp"><i class="fa fa-vcard"></i>Candidates</a>
            <a href="JSP/adminlogin.jsp"><i class="fa fa-user"></i>Admin</a>
            <a href="JSP/aboutus.jsp"><i class="fa fa-group"></i>About Us</a> 
        </div> 
         
    </div><br><br>
    
    <div class="heading">
        <h1 style="text-align:center">WELCOME TO THE E-VOTING SYSTEM </h1><br><br><br><br>
    </div>

    <div class="container">
        <h3 ><b>Make your decision-making process modern, secure, and effective.</b></h3><br>
        <h3> Upgrade from manually counting ballots to an online election system without sacrificing the integrity of your vote</h3><br><br><br><br><br><br><br><br><br>
    </div>
    </section>
    
    <section class="contact">
    <div class="container1">
        <div class="content">
          <div class="left-side">
            <div class="address details">
              <i class="fas fa-map-marker-alt"></i>
              <div class="topic">Address</div>
              <div class="text-one">Surkhet, NP12</div>
              <div class="text-two">Birendranagar 06</div>
            </div>
            <div class="phone details">
              <i class="fas fa-phone-alt"></i>
              <div class="topic">Phone</div>
              <div class="text-one">+0098 9893 5647</div>
              <div class="text-two">+0096 3434 5678</div>
            </div>
            <div class="email details">
              <i class="fas fa-envelope"></i>
              <div class="topic">Email</div>
              <div class="text-one">eVoting@gmail.com</div>
              <div class="text-two">info.eVoting@gmail.com</div>
            </div>
          </div>
          <div class="right-side">
            <div class="topic-text">Send us a message</div>
            <p>If you have any doubts from me or any types of queries related to my website, you can send me message from here. It's my pleasure to help you.</p>
          <form action="#">
            <div class="input-box">
              <input type="text" placeholder="Enter your name">
            </div>
            <div class="input-box">
              <input type="text" placeholder="Enter your email">
            </div>
            <div class="input-box message-box">
                <input type="text" placeholder="Enter your Message">
            </div>
            <div class="button">
              <input type="button" value="Send Now" >
            </div>
            </form>
            </div>
            </div>
            </div>
        </section>

</body>
</html>
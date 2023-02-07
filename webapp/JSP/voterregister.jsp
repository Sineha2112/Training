<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Voter</title>
<link rel="stylesheet" href="/CSS/loginstyles.css">
<style>
#errorMessage{
	margin-bottom: 20px;
	padding: 0px;
	background: #fe8b8e;
	text-align: center;
	font-size: 14px;
	transition: all 0.5s ease;
}
</style>
</head>
<body>
<div class="main">
	
	<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2>Sign Up</h2>
	<form id="registerForm" name="registerForm" onsubmit="validateForm()" action="/registerVoter" method="post">
            
            <div id="errorMessage"></div> 
            
            <div class="form-group">
                <label for="name"></label><br>
                <input type="text" name="name" placeholder="Name" required id="name"><br><br>
               </div>
                
               <div class="form-group">
                <label for="date"></label><br>
                <input type="date" name="dob" placeholder="DOB" id="dob"><br><br>
                </div>
                
                <div class="form-group">
                <label for="voterId"></label><br>
                <input type="text" name="voterId" placeholder="Voter Id" id="voterId"><br><br> 
                   </div>
                       
                       <div class="form-group">
                <label for="fatherName"></label><br>
                <input type="text" name="fatherName" placeholder="Father Name" id="fatherName"><br><br>
                </div>
                <div class="form-group">
                
				<!-- <label for="male">Male
                <input type="radio" id="male" name="gender" value="Male"></label>
				<label for="female">Female
				<input type="radio" id="female" name="gender" value="Female"></label>
				<label for="preferNotToSay">Prefer Not To Say
				<input type="radio" id="preferNotToSay" name="gender" value="Prefer Not To Say"></label> -->
                <div>
                    <label for="gender"></label><br>
                    <input type="checkbox" name="gender" value="male" > Male
                    <input type="checkbox" name="gender" value="female"> Female
                    <input type="checkbox" name="gender" value="prefer not to say">Prefer not to say<br><br>
                </div> </div>
                
                <div class="form-group">
                <label for="address"></label><br>
                <input type="text" name="address" placeholder="Address" id="address"><br><br>
                </div>
                
                <div class="form-group">
                <label for="city"></label><br>
                <input type="text" name="city" placeholder="City" id="city"><br><br>
                </div>
                
                <div class="form-group">
                <label for="Nationality"></label><br>
                <input type="text" name="nationality" placeholder="Nationality" id="nationality"><br><br>
                </div>
                
                <div class="form-group">
                <label for="mobileNumber"></label><br>
                <input type="tel" name="mobileNumber" placeholder="Mobile Number" id="mobileNumber"><br><br>
               </div>
                
                <div class="form-group">
                <label for="email"></label><br>
                <input type="email" name="email" placeholder="Email Id" id="email"><br><br>
                </div>
                
                <div class="form-group">
                <label for="password"></label><br>
                <input type="password" name="password" placeholder="Password" id="password"><br><br>
                </div>
               
                <div class="form-submit">
                    <button type="submit">Register</button>&emsp;&emsp;&emsp;
                    <button type="reset">Cancel</button>
                </div><br>
                    <input TYPE="button" VALUE="Back" onClick="history.go(-1);">
                </div>
        </form>
        <div class="signup-image">
						<figure>
							<img src="\Images\signup-image.jpg" alt="sing up image">
						</figure>
						Already have an account? <a href="residentvoter.jsp" class="signup-image-link">Sign In</a>
					</div>
        </div>
        		
					</div>
				</div>
		</section>
        <script>
        
            function validateForm(){
                //it prevents the default behaviour of navigation
                event.preventDefault();
                let name=document.querySelector("#name").value;
                console.log(name);
                let dob=document.querySelector("#email").value;
                let voterId=document.querySelector("#voterId").value;
                let fatherName=document.querySelector("#fatherName").value;
                let address=document.querySelector("#address").value;
                let city=document.querySelector("#city").value;
                let nationality=document.querySelector("#nationality").value;
                let mobileNumber=document.querySelector("#mobileNumber").value;
                let email=document.querySelector("#email").value;
                let password=document.querySelector("#password").value;
                
                var error=document.getElementById("errorMessage");
                var text;
                error.style.padding="10px";
                
                try{
              
                    if(name==null || name.trim()==""){
                        text="Username cannot be empty";
                        error.innerHTML=text; 
                        return false;
                    }
                    else if( name.length<=2){
                        text="Username must have atleast 3 characters";
                        error.innerHTML=text;
                        return false;
                    }
                    else if(dob==null){
                        text="Date Of Birth cannot be empty";
                        error.innerHTML=text;
                        return false;
                    }
                    else if(voterId==null || voterId.trim()==""){
                        text="Voter Id cannot be empty";
                        error.innerHTML=text;
                        return false;
                    }
                    else if(fatherName==null || fatherName.trim()==""){
                        text="Father Name must have atleast 3 characters";
                        error.innerHTML=text;
                        return false;
                    }
                    else if(address==null){
                        text="Address cannot be empty";
                        error.innerHTML=text;
                        return false;
                    }
                    else if(city==null && city.trim()==""){
                        text="City cannot be empty";
                        error.innerHTML=text;
                        return false;
                    }
                    else if(nationality==null && nationality.trim()==null){
                        text="Nationality cannot be empty";
                        error.innerHTML=text;
                        return false;
                    }
                    else if(nationality!="Indian"){
                        text="You Must Be An Indian To Register";
                        error.innerHTML=text;
                        return false;
                    }
                    else if(mobileNumber.length<10){
                        text="Mobile number must have 10 number";
                        error.innerHTML=text;
                        return false;
                    }
                    else if(email==null || email.trim()==""){
                        text="EmailId cannot have space";
                        error.innerHTML=text;
                        return false;
                    }
                    else if(password==null || password.trim()==""){
                        text="Password cannot be null";
                        error.innerHTML=text;
                        return false;
                    }
                    else if(password.length<8){
                        text="Password must have atleast 8 characters";
                        error.innerHTML=text;
                        return false;
                    }
                    else{
                      alert("Welcome "+name);
                      alert()
                    }
                    let form=document.querySelector("#registerForm");
                	form.style.display = 'none';
                    form.submit();
                } catch(err){
                    console.error(err);
                    console.log("Validation Failed: "+err.message);
                    alert("Error: "+err.message);
                }  
                
               
            }
            function emailValidation(){
            	let email=document.querySelector("#email").value;
            	<%-- <%String query="select email from%>" --%>
            }
        </script>
        </div>
</body>
</html>
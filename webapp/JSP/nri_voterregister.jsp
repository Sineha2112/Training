<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Form</title>
<link rel="stylesheet" href="/CSS/loginstyles.css">
<style type="text/css">
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
		<form id="registerForm" name="registerForm" onsubmit="validateForm()" action="/registerNriVoter" method="post">
           
            <div id="errorMessage"></div> 
            
              <div class="form-group">
                <label for="name"></label><br>
                <input type="text" name="name" placeholder="Name" required id="name"><br>
                </div>
                
                   <div class="form-group">
                <label for="date"></label><br>
                <input type="date" name="dob" placeholder="DOB" id="dob"><br>
                </div>
                
                   <div class="form-group">
                <label for="voterId"></label><br>
                <input type="text" name="voterId" placeholder="Voter Id" id="voterId"><br>  
                  </div>
                  
                     <div class="form-group">    
                <label for="fatherName"></label><br>
                <input type="text" name="fatherName" placeholder="Father Name" id="fatherName"><br>
               </div>
                  <div class="form-group">
                <div>
                    <label for="gender"></label><br>
                    <input type="checkbox" name="gender" value="male" > Male
                    <input type="checkbox" name="gender" value="female"> Female
                    <input type="checkbox" name="gender" value="prefer not to say">Prefer not to say<br><br>
                </div>
                </div>
                
                   <div class="form-group">
                <label for="Nationality"></label><br>
                <input type="text" name="nationality" placeholder="Nationality" id="nationality"><br>
                </div>
                
                   <div class="form-group">
                <label for="address"></label><br>
                <input type="text" name="state" placeholder="State" id="state"><br>
                </div>
                
                   <div class="form-group">
                <label for="city"></label><br>
                <input type="text" name="city" placeholder="City" id="city"><br>
                </div>
                
                   <div class="form-group">
                <label for="email"></label><br>
                <input type="email" name="email" placeholder="Email Id" id="email"><br>
                </div>
                
                   <div class="form-group">
                <label for="password"></label><br>
                <input type="password" name="password" placeholder="Password" id="password"><br>
                </div>
                
                <div class="form-submit">
                    <button type="submit">Sign Up</button>&emsp;&emsp;&emsp;
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
                let dob=document.querySelector("#email").value;
                let voterId=document.querySelector("#voterId").value;
                let fatherName=document.querySelector("#fatherName").value;
                let nationality=document.querySelector("#nationality").value;
                let state=document.querySelector("#state").value;
                let city=document.querySelector("#city").value;
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
                    else if(state==null){
                    	 text="State cannot be empty";
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
                    }
                    let form=document.querySelector("#registerForm");
                    form.style.display = 'none';
                    form.submit();
                } 
                catch(err){
                    console.error(err);
                    console.log("Validation Failed: "+err.message);
                    alert("Error: "+err.message);
                }  
            }
        </script>
</body>
</html>
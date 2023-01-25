<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Sign Up</h2>
	<form id="registerForm" name="registerForm" onsubmit="validateForm()" action="VoterRegisterservlet" method="post">
            <div class="container">
                <label for="name"><b>Enter Name:</b></label><br>
                <input type="text" name="name" placeholder="Name" required id="name"><br><br>
                
                <label for="date"><b>Enter Date Of Birth:</b></label><br>
                <input type="date" name="dob" placeholder="DOB" id="dob"><br><br>
                
                <label for="age"><b>Enter Age:</b></label><br>
                <input type="number" name="age" placeholder="Age" id="age"><br><br>
                
                <label for="voterId"><b>Enter Voter Id:</b></label><br>
                <input type="text" name="voterId" placeholder="Voter Id" id="voterId"><br><br> 
                       
                <label for="fatherName"><b>Enter Father Name:</b></label><br>
                <input type="text" name="fatherName" placeholder="Father Name" id="fatherName"><br><br>
                <div>
                    <label for="gender"><b>Enter Gender:</b></label><br>
                    <input type="checkbox" name="gender" value="male" > Male
                    <input type="checkbox" name="gender" value="female"> Female
                    <input type="checkbox" name="gender" value="prefer not to say">Prefer not to say<br><br>
                </div>
                <label for="address"><b>Enter Address:</b></label><br>
                <input type="text" name="address" placeholder="Address" id="address"><br><br>
                
                <label for="city"><b>Enter City:</b></label><br>
                <input type="text" name="city" placeholder="City" id="city"><br><br>
                
                <label for="Nationality"><b>Enter Nationality:</b></label><br>
                <input type="text" name="nationality" placeholder="Nationality" id="nationality"><br><br>
                
                <label for="mobileNumber"><b>Enter Mobile Number:</b></label><br>
                <input type="tel" name="mobileNumber" placeholder="Mobile Number" id="mobileNumber"><br><br>
                
                <label for="email"><b>Enter Email Id:</b></label><br>
                <input type="email" name="email" placeholder="Email Id" id="email"><br><br>
                
                <label for="password"><b>Enter Password:</b></label><br>
                <input type="password" name="password" placeholder="Password" id="password"><br><br>
                <div>
                    <button type="submit">Register</button>&emsp;&emsp;&emsp;
                    <button type="reset">Cancel</button>
                </div><br>
                    <input TYPE="button" VALUE="Back" onClick="history.go(-1);">
                    <p>Already have an account? <a href="residentvoter.jsp">Sign In</a>.</p>
                </div>
        </form>
        <script>
        
            function validateForm(){
                //it prevents the default behaviour of navigation
                event.preventDefault();
                let name=document.querySelector("#name").value;
                let dob=document.querySelector("#email").value;
                let voterId=document.querySelector("#voterId").value;
                let fatherName=document.querySelector("#fatherName").value;
                let address=document.querySelector("#address").value;
                let city=document.querySelector("#city").value;
                let nationality=document.querySelector("#nationality").value;
                let mobileNumber=document.querySelector("#mobileNumber").value;
                let email=document.querySelector("#email").value;
                let password=document.querySelector("#password").value;
                try{
                    if(name==null || name.trim()==""){
                        throw new Error("Username cannot be empty");
                    }
                    else if( name.length<=2){
                        throw new Error("Username must have atleast 3 characters");
                    }
                    else if(dob==null){
                        throw new Error("Date Of Birth cannot be empty");
                    }
                    else if(voterId==null || voterId.trim()==""){
                        throw new Error("Voter Id cannot be empty");
                    }
                    else if(fatherName==null || fatherName.trim()==""){
                        throw new Error("Father Name must have atleast 3 characters")
                    }
                    else if(address==null){
                        throw new Error("Address cannot be empty");
                    }
                    else if(city==null && city.trim()==""){
                        throw new Error("City cannot be empty");
                    }
                    else if(nationality==null && nationality.trim()==null){
                        throw new Error("Nationality cannot be empty");
                    }
                    else if(nationality!="Indian"){
                        throw new Error("You are not an Indian");
                    }
                    else if(mobileNumber.length<10){
                        throw new Error("Mobile number must have 10 number");
                    }
                    else if(email==null || email.trim()==""){
                        throw new Error("EmailId cannot have space");
                    }
                    else if(password==null || password.trim()==""){
                        throw new Error("Password cannot be null");
                    }
                    else if(password.length<8){
                        throw new Error("Password must have atleast 8 characters");
                    }
                    else{
                      alert("Welcome "+name);
                    }
                    let form=document.querySelector("#registerForm");
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
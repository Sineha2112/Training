<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Candidates</title>
<link rel="stylesheet" href="/CSS/loginstyles.css">
</head>
<body>
<div class="main">
	
	<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						
						<h2>Register </h2>
	<form id="uploadfile" name="uploadfile" action="/regCandidates" method="post">
            
				<div class="form-group">
                <label for="name"></label><br>
                <input type="text" name="name" placeholder="Name" required id="name"><br><br>
                </div>
                
                <div class="form-group">
                <label for="partyName"></label><br>
                <input type="text" name="partyName" placeholder="Party Name" id="partyName"><br><br> 
                </div>
                
                <div class="form-group">
                <label for="partySymbol"></label><br>
                <input type="text" name="partySymbol" placeholder="Party Symbol" id="partySymbol"><br><br>
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
                <label for="age"></label><br>
                <input type="number" name="age" placeholder="Age" id="age"><br><br>
                </div>
                      
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
            	<label for="pdf"></label>
            	<input type="file" name="file" placeholder="File" id="file">
            	</div>
                
                <div>
                    <button type="submit">Submit</button>&emsp;&emsp;&emsp;
                    <button type="reset">Cancel</button>
                </div><br>
                    <input TYPE="button" VALUE="Back" onClick="history.go(-1);">
                </div>
        </form>
        <div class="signup-image">
						<figure>
							<img src="\Images\signup-image.jpg" alt="sing up image">
						</figure>
					</div>
         </div>
        		
					</div>
				</div>
		</section>
</body>
</html>